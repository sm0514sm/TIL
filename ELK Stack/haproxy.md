> `INSTALL` 파일 내용 참고

### 1. Quick build & install

```bash
make clean
make -j $(nproc) TARGET=linux-glibc USE_<option>=1 ...
make install
```



### 2. Basic principles

- `-j $(proc)` : 병렬 빌드를 위한 사용 가능한 프로세서의 수
- `TARGET=` : Optimized OS 설정 
  - linux-glibc: for Linux kernel 2.6.28 and above



### 3. Build environment

- GNU make >= 3.80
- GCC >= 3.4
  - `gcc --version`으로 확인
- `yum groupinstall "Development Tools"`



### 4. Dependencies

