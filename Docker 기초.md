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

- 

  

