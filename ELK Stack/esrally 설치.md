# Esrally 설치 과정

## Python3.8 설치

3.8 이상의 버전이 필요

1. `Python-3.8.3.tgz` 구하기

2. ```bash
   # nexus.repo 설정 필요
   yum -y groupinstall "Development Tools"
   yum -y install openssl-devel bzip2-devel libffi-devel
   gcc --version
   tar xvf Python-3.8.3.tgz
   cd Python-3.8.3/
   ./configure --enable-optimizations
   make altinstall
```
   
3. 링크 파일 만들기

   ```bash
   cp /usr/local/bin/python3.8 /usr/bin
   ln -s /usr/bin/python3.8 /usr/bin/python3
   cp /usr/local/bin/pip3.8 /usr/bin
   ln -s /usr/bin/pip3.8 /usr/bin/pip3
   ```

4. 동작 확인

   ```sh
   python3				// python3.8 이 실행되나?
   pip3
   ```

   

## esrally dependency

### Python dependecy

```bash
pip3 install typing_extensions-3.7.4.3-py3-none-any.whl
pip3 install idna-3.0-py2.py3-none-any.whl
pip3 install multidict-4.6.0-cp38-cp38-manylinux1_x86_64.whl
pip3 install yarl-1.5.0-cp38-cp38-manylinux1_x86_64.whl
pip3 install async_timeout-3.0.1-py3-none-any.whl
pip3 install attrs-19.3.0-py2.py3-none-any.whl
pip3 install chardet-3.0.0-py2.py3-none-any.whl
pip3 install aiohttp-3.6.0-py3-none-any.whl
```

### Git

```sh
yum remove -y git
# git-2.8.0-1.WANdisco.308.x86_64.rpm
# perl-Git-2.8.0-1.WANdisco.308.noarch.rpm
yum install *.rpm
git --version
```



## 실행

### 트랙 만들기

```

```



### 트랙 레이스

```sh
esrally --track-path=/elk_data/esrally-dist-2.0.2/track/esrally-track-index --pipeline=benchmark-only --target-hosts=10.18.253.89:9201,10.18.253.89:9200,10.18.253.87:9201,10.18.253.87:9202 --client-options="timeout:60,use_ssl:true,verify_certs:false,ca_certs:'/elk_data/logstash/config/cert/ca/ca.crt',basic_auth_user:'test',basic_auth_password:'Hmgmss2020'"
```

```sh
esrally --track-path=/elk_data/esrally-dist-2.0.2/track/esrally-track-index --pipeline=benchmark-only --target-hosts=10.18.253.91:9200 --client-options="timeout:60,use_ssl:true,verify_certs:false,ca_certs:'/elk_data/logstash/config/cert/ca/ca.crt',basic_auth_user:'test',basic_auth_password:'Hmgmss2020'"
```

```sh
esrally --track-path=/elk_data/esrally-dist-2.0.2/track/esrally-track-index --pipeline=benchmark-only --target-hosts=10.18.253.86:9200 --client-options="timeout:60,use_ssl:true,verify_certs:false,ca_certs:'/elk_data/logstash/config/cert/ca/ca.crt',basic_auth_user:'test',basic_auth_password:'Hmgmss2020'"
```
