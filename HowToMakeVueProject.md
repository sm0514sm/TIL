* vuex, router, vuetify 등 추가
 * 해당 골격을 토대로 상세 코드 작성 전까지 제작해야함

----
## 개발 전 설정
### 1. PowerShell 관리자 권한으로 아래 명령어 수행
```
Set-ExecutionPolicy RemoteSigned
```
### 2. VS code 플러그인 설치
 * Live Server
 * Vue Vs Code Extension Pack
 * Html snippets

### 3. [node 설치|[https://nodejs.org/en/]]
### 4. vue/cli, yarn 설치를 위해 CMD창에서 아래 명령어 수행
```
npm -g install @vue/cli
npm -g install yarn{code}
```
### 5. 새로운 프로젝트 생성

vue create testvue{code}
> 제가 만든 것을 Git에서 땡겨쓰므로 해당 작업은 하실 필요 없습니다.

### 6. `package.json` 에서 scripts.serve에서 포트 번호를 바꾸거나 추가
### 7. 패키지 설치
기존 패키지 등록 안된 신규 프로젝트인 경우
```
npm install --save vuex
npm install --save vue-router
npm install --save vuetify
npm install --save axios
```
기존 프로젝트인 경우
```
npm install
// 혹은
yarn install
```
