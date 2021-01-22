[TOC]

## https

> [Elasticsearch, Kibana, Beats, Logstash의 보안을 유지하기 위한 SSL, TLS, HTTPS 구성]([Elasticsearch, Kibana, Beats, Logstash의 보안을 유지하기 위한 SSL, TLS, HTTPS 구성 | Elastic Blog](https://www.elastic.co/kr/blog/configuring-ssl-tls-and-https-to-secure-elasticsearch-kibana-beats-and-logstash#enable-tls-kibana))
>
> [Elastic Cluster 구성 6 - Jongmin's blog (kimjmin.net)](http://kimjmin.net/2018/01/2018-01-build-es-cluster-6/)

### 1. 인증서 생성

1. 인증서 파일 생성

   ```bash
   bin/elasticsearch-certgen
   ```

   ```
   Please enter the desired output file [certificate-bundle.zip]:  # 압축파일명
   Enter instance name: hmgmss	# 인증서 인스턴스 명
   Enter name for directories and files [hmgmss]:  # 디렉토리, 파일 명
   Enter IP Addresses for instance (comma-separated if more than one) []: 10.11.13.121,10.11.13.122,10.11.13.123,10.11.13.124
   Would you like to specify another instance? Press 'y' to continue entering instance information: n
   ```

2. 압축파일을 각 node의 `./config/` 로 이동

   > 처음에는 각 호스트의 `/data/`에 둬서 다같이 쓰려했지만 권한 문제로 안됨

3. 압축 해제 `unzip certificate-bundle.zip`



### 2. elasticsearch 설정

> [elasticsearch security doc](https://www.elastic.co/guide/en/elasticsearch/reference/current/configuring-tls.html#tls-transport)

1. 아래 내용 추가

   ```yml
   # SSL
   xpack.security.http.ssl.key: cert/hmgmss/hmgmss.key
   xpack.security.http.ssl.certificate: cert/hmgmss/hmgmss.crt
   xpack.security.http.ssl.certificate_authorities: [ "cert/ca/ca.crt" ]
   # xpack.security.transport.ssl.enabled: true
   xpack.security.http.ssl.enabled: true
   ```

2. Java에 java.io.FilePermission 권한 주기

   ```bash
   sudo vim /usr/lib/jvm/jre-1.8.0-openjdk.x86_64/lib/security/java.policy
   ```

   ```
   grant {
     ... 중략 ...
   
           permission java.io.FilePermission "<<ALL FILES>>", "read";
   };
   ```

3. elasticsearch restart



### 3. kibana 설정

```yaml
# Enables SSL and paths to the PEM-format SSL certificate and SSL key files, respectively.
# These settings enable SSL for outgoing requests from the Kibana server to the browser.
server.ssl.enabled: true
server.ssl.certificate: /data/kibana-7.9.1/config/cert/hmgmss/hmgmss.crt
server.ssl.key: /data/kibana-7.9.1/config/cert/hmgmss/hmgmss.key

# Optional settings that provide the paths to the PEM-format SSL certificate and key files.
# These files are used to verify the identity of Kibana to Elasticsearch and are required when
# xpack.security.http.ssl.client_authentication in Elasticsearch is set to required.
#elasticsearch.ssl.certificate: /data/kibana-7.9.1/config/cert/ca/ca.crt
#elasticsearch.ssl.key: /data/kibana-7.9.1/config/cert/ca/ca.key

# Optional setting that enables you to specify a path to the PEM file for the certificate
# authority for your Elasticsearch instance.
elasticsearch.ssl.certificateAuthorities: [ "/data/kibana-7.9.1/config/cert/ca/ca.crt" ]
```



### 4. logstash 설정

1. `config/logstash.yml` 수정 (Authentication과 헷갈리지 않기)

   ```yaml
   xpack.monitoring.elasticsearch.hosts: ["https://10.11.13.121:9200", "https://10.11.13.122:9200", "https://10.11.13.123:9200"]
   xpack.monitoring.elasticsearch.ssl.certificate_authority: /data/logstash-7.9.1/config/cert/ca/ca.crt
   ```

2. `conf`파일들 수정

   ```
   elasticsearch {
       id => "palofw_id_output"
       hosts => [ "https://10.11.13.121:9201", "https://10.11.13.122:9201", "https://10.11.13.123:9201" ] 
       codec => json
       index => "palofw-%{index_day}"
       user => 'logstash_writer'
       password => 'Hmgmss2020!'
       cacert => '/data/logstash-7.9.1/config/cert/ca/ca.crt'
   }
   ## https  것과 cacert 추가
   ```

   

### 5. cerebro 설정



### 6. Moloch 설정

> *** 주의** : elasticsearch cluster(121~124)와는 다른 cert 파일을 사용한다
>
> - Moloch은 ip가 아닌 hostname으로 판별하기 때문에 인증서 생성시 dns설정도 필요

```yaml
elasticsearch=https://10.11.13.118:9200

# How often to create a new elasticsearch index. hourly,hourly6,daily,weekly,monthly
# Changing the value will cause previous sessions to be unreachable
rotateIndex=daily

# Cert file to use, comment out to use http instead
certFile=/data/moloch/etc/cert/hmgmoloch/hmgmoloch.crt

# File with trusted roots/certs. WARNING! this replaces default roots
# Useful with self signed certs and can be set per node.
caTrustFile=/data/moloch/etc/cert/ca/ca.crt

# Private key file to use, comment out to use http instead
keyFile=/data/moloch/etc/cert/hmgmoloch/hmgmoloch.key
```



## Authentication

> https://danawalab.github.io/elastic/2020/05/20/Elasticsearch-basic-security.html

1. 1번 Node master에서 p12 인증서 생성

   ```bash
   $ elasticsearch-certutil cert -out config/elastic-certificates.p12 -pass ""
   ```

2. 생성된 `elastic-certificates.p12`을 모든 노드 config에 복사

3. 모든 노드의 `elasticsearch.yml` 에 아래 내용 추가

   ```bash
   xpack.security.enabled: true
   xpack.security.transport.ssl.enabled: true
   xpack.security.transport.ssl.verification_mode: certificate
   xpack.security.transport.ssl.keystore.path: elastic-certificates.p12
   xpack.security.transport.ssl.truststore.path: elastic-certificates.p12
   ```

4. 모든 노드 재실행

5. 1번 Node master에서 비밀번호 설정

   ```bash
   $ elasticsearch-setup-passwords interactive  // 대화형
   ```

6. `10.11.13.121:9200`에 접속하여 로그인 성공 확인

7. 키바나 설정

8. 로그스태시 설정 [참고링크](https://www.elastic.co/kr/blog/configuring-ssl-tls-and-https-to-secure-elasticsearch-kibana-beats-and-logstash#prepare-logstash)

   1. create role (kibana or curl 이용)

      ```
      POST /_security/role/logstash_write_role
      {
          "cluster": [
            "monitor",
            "manage_index_templates"
          ],
          "indices": [
            { //접근 권한을 가질 수 있는 인덱스 설정 필수!!
              "names": [		
                "palofw-*",
                "cisco*"
              ],
              "privileges": [
                "write",
                "create_index"
              ],
              "field_security": {
                "grant": [
                  "*"
                ]
              }
            }
          ],
          "run_as": [],
          "metadata": {},
          "transient_metadata": {
            "enabled": true
          }
      }
      ```

   2. User 생성 (kibana or curl 이용)

      ![logstash_writer 사용자 생성](img/Elasticsearch%20Security/Enable-security-4.jpg)

   3. `logstash.yml`에 xpack 내용 추가

      ```yaml
      xpack.monitoring.enabled: true
      xpack.monitoring.elasticsearch.username: logstash_system
      xpack.monitoring.elasticsearch.password: Hmgmss2020!
      xpack.monitoring.elasticsearch.hosts: ["http://10.11.13.121:9200", "http://10.11.13.122:9200", "http://10.11.13.123:9200"]
      ```

   4. `.conf`에 login 정보 추가

      ```conf
      output {
          elasticsearch {
              hosts => [ "10.11.13.121:9201", "10.11.13.122:9201", "10.11.13.123:9201" ]
              codec => json
              index => "palofw-%{index_day}"
              user => 'logstash_writer'
              password => 'Hmgmss2020!'
          }
      }
      ```

   5. logstash 실행

9. 