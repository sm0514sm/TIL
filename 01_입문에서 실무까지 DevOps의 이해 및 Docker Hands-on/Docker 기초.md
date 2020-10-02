## Docker 기초

#### 머신 안에 가상 머신

커널이 하는 역할을 함 - 부팅이 되어있는 장비 위에 또 부팅하는 작업 (체크할 필요 없는뎅)

#### 도커

커널을 공유해서 부팅 과정이 없음 

하나의 도커 이미지엔 하나의 어플리케이션 (프로세스 방식으로 돌어가서)

LXC(다른 컨테이너)와의 차이점은 docker hub 이미지를 직접 만들지 않아도 됨

aufs(파일시스템) 적층형 이미지(base 이미지 + 다른 소스 이미지) 효율적인 저장소 관리

---



## Docker 주요사용법

![image-20200820232341399](rsc/Docker%20%EA%B8%B0%EC%B4%88/image-20200820232341399.png)

- `docker pull busybox` : busybox라는 가벼운 도구모음? 리눅스 이미지를 불러온다.

- `docker images` : 현재 설치된 이미지 리스트를 보인다

- `docker run -it busybox sh` : busybox 이미지에서 sh 명령어를 실행한다.

  > `exit` 하면  컨테이너에서 나옴. 메모리에서 detached
  >
  > Ctrl + p + q 로 나오면 남아있음
  >
  > ![image-20200820230856239](rsc/Docker%20%EA%B8%B0%EC%B4%88/image-20200820230856239.png)

- `docker ps -a` : running 중이지 않는 것까지 모두 표시

  > ![image-20200820230930608](rsc/Docker%20%EA%B8%B0%EC%B4%88/image-20200820230930608.png)

- `docker start [NUMBER]` : Container 다시 실행

- `docker attach [NUMBER]` : 실행중인 컨테이너로 진입

- `docker commit [NUMBER]  [NAME]:[VERSION]` : 해당 컨테이너 스냅샷을 떠서 새롭게 만듬

- `docker tag [NAME]:[VERSION] [NEW_NAME]:[NEW_VERSION]` : 이름 바꾸기

  > ![image-20200820231753115](rsc/Docker%20%EA%B8%B0%EC%B4%88/image-20200820231753115.png)






![image-20200820232326097](rsc/Docker%20%EA%B8%B0%EC%B4%88/image-20200820232326097.png)

- `docker login` : dockerhub에 push (private 저장소 pull)하기 위해 로그인

- `docker push [ID]/[NAME]:[VERSION]` : dockerhub 에 push

  > ![image-20200820233854191](rsc/Docker%20%EA%B8%B0%EC%B4%88/image-20200820233854191.png)
  >
  > 적층형이기 때문에 busybox 위에 push함을 알 수 있다. (효율적이여)

- `docker rmi [NAME]` :  이미지 삭제

  > `docker save [NAME] > ./[NAME].tgz` 로 binary하게 저장
  >
  > `docker load < ./[NAME].tgz` 로 불러오기 가능
  >
  > > 망분리 환경에서 검증이된 이미지를 파일단위로 관리하기 위함

- `docker cp [CONTAINER_ID]:[파일경로] [HOST경로]` : 컨테이너 내부의 파일을 HOST로 복사





## Docker 주요사용법 2

### DockerFile

> 이미지 만들어 설정까지 하기

이미지 가져와서 설치까지 한번에 하는데 이를 직접 명령어 이용하면 기록이 안남아서 틀리기 쉽다.

그래서 한번에 종합해서 하도록 만듬.

```
- FROM  : BASE 이미지 (OS 등)으로 사용할 Layer 가져오는단계
- LABEL : 도커파일 자체 Meta 정보를 입력하는 부분 (빌드 자동화에 사용)
- RUN   : 설치/설정을 위한 실행 부분 (리눅스상에서 실행해야할 명령어)
- ENV   : 환경변수에 대한 선언
- COPY  : Local 디스크의 파일을 컨테이너 내부로 복사
- ENTRYPOINT : 런타임시에 최종적으로 실행되는 명령어 (항상 맨마지막에 수행됨)
- EXPOSE : Port를 외부로 mapping하기 위한 정보 (컨테이너가 몇번포트를 쓰냐)
```

#### 예시

```dockerfile
## Dockerfile
FROM golang:1.11

LABEL version=0.1
LABEL name=go_revel

ENV GOPATH $GOPATH:/go/src 

#RUN apt-get update && \
#    apt-get upgrade -y

RUN go get github.com/revel/revel && \
    go get github.com/revel/cmd/revel && \
    go get github.com/jinzhu/gorm && \
    go get github.com/go-sql-driver/mysql

RUN mkdir /go/src/myapp

ENTRYPOINT systemctl run test_app

EXPOSE 9000
```



### Docker-compose

만들어져있는 이미지들을 한번에 올리는 것.

```
- image : 사용할 docker image명
- volumes : container에 mount 할 경로 (docker-compose.yml 이 있는 경로로부터)
- entrypoint : container 적재시 최종 실행되는 명령어
- links : container 간 dependency 적용 (어떤 container가 이미 있어야하나)
- ports : container와 Host간 port를 mapping
- environment : container 내부 환경변수 지정
```

#### 예시

```yml
version: '2'
services:
    db:
        image: mysql:5.7
        environment:
            - MYSQL_ROOT_PASSWORD=secret
            - MYSQL_DATABASE=revel
            - MYSQL_USER=revel
            - MYSQL_PASSWORD=secret
        volumes:
            - ./datadir:/var/lib/mysql      # ./datadir은 host, /val/lib/mysql container
    web:
#        build: . 
# build가 주석이 아니면 이미지를 외부에서 받아오지 않고 local의 dockerfile으로 부터 가져옴?
        image: goody80/go_revel:0.1
        volumes:
            - ./myapp:/go/src/myapp
        entrypoint: revel run myapp
        ports:
            - 9000:9000
#        depends_on:   # (depends_on is same with links)
        links:
            - db
        environment:
            - APP_NAME=RalfApp
            - APP_PORT=9000
            - APP_DB=revel
            - APP_DB_PW=secret
#volumes:
#    db_data:
#      driver: local
```



### 실행

![image-20200904211029463](img/Docker%20%EA%B8%B0%EC%B4%88/image-20200904211029463.png)

> shell script 를 실행시켰다.
>
> 안에는 `docker-compose up -d ` 라는 명령어로 실행



