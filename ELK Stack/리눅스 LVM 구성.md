# 리눅스 LVM 구성

[toc]

## LVM

### 설명

Logical Volume을 효율적이고 **유연하게 관리**하기 위한 커널의 한 부분이자 프로그램이다. 기존에는 파일시스템이 블록 장치에 직접 접근해서 읽고/쓰기를 했다면 LVM을 사용하면 파일 시스템이 LVM이 만든 가상의 블록 장치에 읽고/쓰기를 함

![image-20200527170301709](img/%EB%A6%AC%EB%88%85%EC%8A%A4%20LVM%20%EA%B5%AC%EC%84%B1/image-20200527170301709.png)

---



## LVM으로 원하는 파티션 만들고 크기 조정

### <span style="color:red">요약</span>

1. `fdisk /dev/(장치명)` p와 n 파티션 타입 LVM
2. `pvcreate` 을 이용해 PV 생성
3. `vgcreate`으로 2에서 만든 PV들 그룹으로 생성
4. `lvcreate`로 LV 생성				-*- 실 작업은 여기부터 함*
5. `mkfs`를 이용해 생성한 LV 파일시스템 포맷
6. 부팅시 자동으로 mount되도록 `/etc/fstab`에 기술

---

### 1. `fdisk /dev/(장치명)` 저장장치에 파티션 설정

> `fdisk -l` 파티션 테이블 출력

1. `fdisk /dev/(장치명)` 입력하여 파티션 나눌 장치 들어가기
2. Command `n`과 `t`이용해 파티션 생성 및 타입 변경 (3개로 나눌거면 3번 반복)



### 2. `pvcreate` 을 이용해 PV 생성

1. `pvcreate /dev/(장치명)(번호)` 을 이용해 1에서 만든 파티션으로 PV생성
2. `pvscan`으로 현재 존재하는 PV목록 확인



### 3. `vgcreate`으로 2에서 만든 PV들 그룹으로 생성

1. `vgcreate VG명 PV1 PV2 PV3 ...`으로 그룹 만들기
2. `vgdisplay`로 VG 생성 확인



### 4.`lvcreate`로 LV 생성

- `lvcreate -l 크기 -n LV명 VG명`으로 VG로부터 크기에 해당하는 LV 생성
  - `lvcreate -L 10GB -n testLV1 testvg` : testvg로부터 testLV1이라는 10GB LV 생성
  - `lvcreate -l 10%VG -n testLV2 testvg` : testvg로부터 testLV2이라는 VG10%크기 LV 생성
  - `lvcreate -l 100%FREE -n testLV3 testvg` : testvg의 남은 공간 모두 가지는 LV 생성

- `lvextend -l +100%FREE /dev/vg명/LV명` : 크기 확장 시키기
- `lvdisplay` : LV 확인



### 5. `mkfs`를 이용해 생성한 LV 파일시스템 포맷

- `mkfs.파일시스템 /dev/mapper/VG명-LV명`
  - *EX :* `mkfs.ext4 /dev/mapper/testvg-testLV1`
- `mkfs.파일시스템 /dev/VG명/LV명`도 되는 것 같다.
  - *EX :* `mkfs.xfs /dev/cl/var`

- 마운트 하기 : `/dev/VG명/LV명`
  - *EX :* `mount /dev/cl/var /var`



### 6. 부팅시 자동으로 mount되도록 `/etc/fstab`에 기술

1. `vi /etc/fstab` 입력
2. `/dev/VG명/LV명    /지정한 위치    파일시스템 defaults    0    0 ` 추가하기
   - `/dev/cl/var			/var			xfs		defaults		0 0`



---



## 기타 참고

1. `vgscan `
   - 설명: 디스크에 있는 볼륨그룹(VG:Volume Group)를 검색하여 /etc/lvmtab 파일을 생성한다. fdisk를 이용하여 파티션을 속성을 LVM으로 지정한 후에 이 명령을 사용한다. 
   - 사용법 `vgscan`
2. pvcreate 
   - 설명: 물리적 볼륨(PV:Physical Volume)을 생성하는 명령어이다. fdisk를 이용하여 파티션을 분할하고 LVM 속성으로 지정한 뒤에 해당 파티션을 PV로 만들 때 사용하는 명령이다. 
   - 사용법 : `pvcreate 디바이스명` 
   - 사용예 `pvcreate /dev/hdb1 `
3. `vgcreate `
   - 설명: 볼륨그룹을 생성하는 명령어로 생성된 PV를 지정한 볼륨그룹에 포함시키면서 생성한다.  
   - 사용법 : `vgcreate 볼륨그룹명 디바이스명 디바이스명 `
   - 사용예 vgcreate lvm /dev/hda7 /dev/hdb1 => lvm 이라는 볼륨그룹을 생성하고 /dev/hda7, /dev/hdb1 이라는 PV를 포함시킨다. 
4. `vgdisplay `
   - 설명: 볼륨그룹의 속성과 정보를 보여주는 명령어이다. 
   - 사용법 : `vgdisplay [option] [볼륨그룹명] `
   - option -v: 좀 더 자세히 보여주는 옵션으로 Volume Group이외에 gical Volume과 Physical Volume도 같이 보여준다. 
   - 사용예 
     1. `# vgdisplay` : Volume Group의 내용을 보여준다. 
     2. `# vgdisplay -v lvm` : lvm이라는 Volume Group의 내용을 자세히 보여준다. 
5. `lvcreate `
   - 설명: 볼륨그룹안에 LV(Logical Volume)을 생성하는 명령이다. 
   - 사용법 lvcreate 옵션 볼륨그룹명 
   - option -L: LV의 사이즈를 지정하는 옵션으로 K(kilobytes), M(megabytes), G(gigabytes), T(terabyt es) 단위를 붙여 지정가능하다. -l: LV의 사이즈를 지정하는 옵션으로 pe의 개수로 용량을 지정한다. 참고로 보통 1pe당 4MB 이다. -n: LV의 이름을 지정하는 옵션이다. 
   - 사용예 
     1. `# lvcreate -L 2000M -n backup lvm` : lvm이라는 볼륨그룹에 backup라는 이름으로 2Gigabytes 용량으로 LV을 생성한다. 
     2. `# lvcreate -l 250 -n data lvm` : lvm이라는 볼륨그룹에 data라는 이름으로 250pe(약 1GB)용량으로 LV을 생성한다. 
6. `lvscan `
   - 설명: 디스크에 있는 Logical Volume을 찾아준다. 
   - 사용법 : `lvscan [option] `
   - option : `-v` 정보를 자세히 보여준다. 
   - 사용예 : `lvscan `
7. `lvdisplay `
   - 설명: Logical Volume의 정보
   - 사용법 : `lvdisplay [option] LV명`
   - option : `-v` 정보를 자세히 보여준다. 
   - 사용예 
     `# lvdisplay -v /dev/lvm/data`  /dev/lvm/data라는 LV의 정보를 자세히
8. `vgextend `
   - 설명: 미리 생성된 Volume Group에 추가로 Phycical Volume을 추가
   - 사용법 : `vgextend 볼륨그룹명 새PV명 `
   - 사용예 
     `# vgextend lvm /dev/hdc1` lvm이라는 볼륨그룹에 /dev/hdc1을 추가
9. `vgreduce `
   - 설명: 볼륨그룹에 있는 Physical Volume을 삭제
   - 사용법 : `vgreduce 볼륨그룹명 PV명 `
   - 사용예 
     `# vgreduce lvm /dev/hdc1` lvm이라는 볼륨그룹에서 /dev/hdc1을 삭제한다. 
10. `lvextend `
    - 설명: Logical Volume의 용량을 확장하는 명령이다. 
    - 사용법 : `lvextend 옵션 [볼륨그룹명] LV명 `
    - option : `-l +사이즈` 지정한 PE수만큼 용량을 늘린다. 
      `-L +사이즈[kmgt]` 지정한 사이즈만큼 용량을 늘린다. 단위를 표시하지 않으면 기본 Megabytes 단위이다. 
    - 사용예 
      `[root@www root]# lvextend -L +200M /dev/lvm/data` 추가로 200MB를 할당
11. `lvreduce `
    - 설명: Logical Volume의 용량을 줄임 
    - 사용법 : `lvreduce 옵션 [볼륨그룹병] LV명 `
    - option : `-l -사이즈` 지정한 PE수만큼 용량을 줄인다. 
      `-L -사이즈` 지정한 사이즈만큼 용량을 줄인다. 단위를 표시하지 않으면 기본 단위는 Megabytes 이다.
    - 사용예
      `# lvreduce -L -500 /dev/lvm/data`  /dev/lvm/data의 용량을 500MB 줄인다. 
12. `vgchange `
    - 설명: 볼륨그룹을 속성을 변경하는 명령으로 볼륨그룹을 사용가능여부, 최대 LV 갯수등을 변경 할 수 있다.
    - 사용법 :` vgchange 옵션 볼륨그룹명 `
    - option : `-a y|n` : 볼륨그룹의 사용여부를 지정한다. `-l 갯수`: 해당 볼륨그룹에 생성할 수 있는 최대 Logical Volume수를 지정한다. 
    - 사용예 
      - `# vgchange -a y lvm`  : lvm이라는 볼륨그룹을 활성화
      - `# vgchange -a n lvm` : lvm이라는 볼륨그룹을 비활성화
      - `# vgchange -l 100 lvm` : lvm이라는 볼륨그룹을 최대 LV수를 100개로 지정
13. `vgremove `
    - 설명: 볼륨그룹을 제거하는 명령이다. 
    - 사용법 : `vgremove 볼륨그룹명 `
    - 사용예 
      `# vgremove lvm` lvm이라는 볼륨그룹을 삭제한다.