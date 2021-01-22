# Open Distro 란?

Elasticsearch의 부가 가치 배포 버전으로서 100% 오픈 소스(Apache 2.0 라이선스)이며 AWS에서 지원합니다. Elasticsearch용 Open Distro는 Elasticsearch 및 Kibana에 오픈 소스 코드를 활용합니다. 이 버전은 일회성 프로젝트가 아니며 AWS에서는 계속해서 배포와 패치를 통해 이 프로젝트를 계속 발전시켜 나갈 것입니다.

첫 출시 버전에는 Elasticsearch와 [Kibana](https://github.com/elastic/kibana) 외에 일련의 고급 보안, 이벤트 모니터링 및 알림, 성능 분석 및 SQL 쿼리 기능도 포함하고 있습니다(이러한 기능은 잠시 후에 추가 설명). [소스 코드 리포](http://opendistro.github.io/) 외에도, Elasticsearch 및 Kibana용 Open Distro는 RPM 및 Docker 컨테이너로 제공되며 SQL JDBC 및 PerfTop CLI를 위한 다운로드가 별도로 제공됩니다. 이 코드는 노트북, 데이터 센터 또는 클라우드 모두에서 실행할 수 있습니다.



## Open Distro for Elasticsearch 설치

> [tar로 설치 가이드 링크]([Tarball - Open Distro for Elasticsearch Documentation (opendistro.github.io)](https://opendistro.github.io/for-elasticsearch-docs/docs/install/tar/))

### 기본 설치

```bash
$ curl https://d3g5vo6xdbdb9a.cloudfront.net/tarball/opendistro-elasticsearch/opendistroforelasticsearch-1.9.0.tar.gz -o opendistroforelasticsearch-1.9.0.tar.gz
$ tar -zxf opendistroforelasticsearch-1.9.0.tar.gz
$ cd opendistroforelasticsearch-1.9.0
$ ./opendistro-tar-install.sh
```

실행 중 `/dev/shm` 에 대한 permission error 발생한다.

root 로 접속해서 해당 디렉토리에서 권한 을 준 후 다시 실행한다.

```bash
curl -XGET https://localhost:9200 -u admin:admin --insecure
curl -XGET https://localhost:9200/_cat/plugins?v -u admin:admin --insecure
```

위의 명령어를 입력해 정상적으로 올라왔는지 확인한다.

![image-20200928165145415](img/Open%20Distro%20%EC%84%A4%EC%B9%98/image-20200928165145415.png)



### 설정

> 중요 설정
>
> - vm.max_map_count 설정
>
>
> 1. ```bash
>    cat /proc/sys/vm/max_map_count  # 로 count 수 확인
>    ```
>
> 2. 값이 262144보다 작다면 `vim /etc/sysctl.conf` 에서 아래 내용 추가
>
>    ```conf
>    vm.max_map_count=262144
>    ```
>
> 3. sysctl reload
>
>    ```bash
>    sudo sysctl -p
>    ```
>
> - vim /etc/security/limits.conf
>
>   ```
>   *       soft    nofile          81920
>   *       hard    nofile          81920
>   *       soft    nproc           81920
>   *       hard    nproc           81920
>   *       soft    memlock         unlimited
>   *       hard    memlock         unlimited
>   ```
>
>   elasticsearch 계정 로그아웃 후 다시 로그인 해야함

```yaml
cluster.name: HMG-MSS-TEST
bootstrap.memory_lock: true
network.host: 10.11.13.124
http.port: 9200
```



## Open Distro Kibana 설치

### 기본 설치

```bash
$ curl https://d3g5vo6xdbdb9a.cloudfront.net/tarball/opendistroforelasticsearch-kibana/opendistroforelasticsearch-kibana-1.9.0.tar.gz -o opendistroforelasticsearch-kibana-1.9.0.tar.gz
$ tar -zxf opendistroforelasticsearch-kibana-1.9.0.tar.gz
$ cd opendistroforelasticsearch-kibana
$ ./bin/kibana
```



### 설정

```yaml
elasticsearch.hosts: https://10.11.13.124:9200
elasticsearch.ssl.verificationMode: none
elasticsearch.username: kibanaserver
elasticsearch.password: kibanaserver
elasticsearch.requestHeadersWhitelist: ["securitytenant","Authorization"]

server.port: 5605
server.host: 10.11.13.124

opendistro_security.multitenancy.enabled: true
opendistro_security.multitenancy.tenants.preferred: ["Private", "Global"]
opendistro_security.readonly_mode.roles: ["kibana_read_only"]

newsfeed.enabled: false
telemetry.optIn: false
telemetry.enabled: false
```

























