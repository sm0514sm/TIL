### 노하우

- Image 만들때 소문자만 가능하고 private registry의 경우 URI 포함
- Runtime시 foregound mode만 가능함
- 하나의 docker container에는 하나의 process만 운영
- Ubuntu host 환경을 추천 - FS이 aufs & 다른OS는 Device-mapper 문제가 있어서
- privileged mode를 통한 Host system 관리 [링크](http://bit.ly/elk_docker)
- [12factor 필독 링크](https://12factor.net/ko/)

---

## Rancher 설치 및 Docker containter orchestration

> Rancher 여러개의 호스트를 하나의 자원으로하고 컨테이너를 어떻게 나눌것인지?

[Rancher 링크](https://rancher.com/quick-start)



## Prometheus 를 통한 Host 모니터링

