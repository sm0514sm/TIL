- 레플리카가 많아질수록 색인 성능은 반비례
- 레플리카의 수는 언제든 변경가능하므로 레플리카 수 조절
- 인덱스당 최대 샤드 수 1024 (더 이상하면 마스터 노드 너무 힘듬)
- 샤드가 많아질 수록 마스터 노드 부하 증가(대신 검색 성능 증가)
- 샤드의 크기가 클 수록 복구 작업 힘듬
- elasticsearch 권장 샤드 크기 : 50GB
- 하나의 샤드에서 색인가능한 document 수 20억 (정확히 2,147,483,519)
- 하나의 인덱스에서 저장할 수 있는 최대 document = 1024 * 20억 = 2조

---

- Xms(최소힙크기), Xmx(최대힙크기) 힙크기 변경시에 성능 저하 가능성 있으므로 같게 해주는게 유리

- 힙크기는 최대 커도 32GB 이하로두기

- 일반적으로 힙크기는 클 수록 좋음

- 하드웨어의 50%를 메모리 크기로 둠 (한 하드웨어에 2개 노드 24GB, 24GB)

- cluster.routing.allocation.same_shard.host: true // 하나의 물리 서버에 다수의 데이터 노드 사용시 고가용성 유지를 위해
  (프라이머리와 레플리카 샤드의 같은 물리서버에 위치 방지)

- `java -Xmx32766m -XX:+PrintFlagsFinal -version | grep UseCompressedOops` 를 이용해서 최대 힙크기를 32766MB(31.998GB)로 설정했을 때 compressed OOP 사용하는지 확인가능

- ` java -XX:+UnlockDiagnosticVMOptions -XX:+PrintCompressedOopsMode 2>/dev/null | grep Compressed | grep Oops` zero-based compressed OOP 사용 크기 확인

  ![image-20200728092345468](img/Elasticsearch%20%EC%84%A4%EC%A0%95/image-20200728092345468.png)

- `cat /proc/sys/vm/max_map_count` : 가상메모리에서 생성 가능한 mmap 개수 확인(기본 : 65530)
  (262144 보다 작으면 Elasticsearch가 강제종료시킴)

  1. `sysctl -w vm.max_map_count = 262144` 로 변경 가능 (일시적)
  2. `vim /etc/sysctl.conf`에서 직접 vm.max_map_count 값 변경 (영구적)

  `sysctl vm.max_map_count`로 확인

- 엘라스틱서치에서는 스와핑 비활성 해야함 (절대절대 비활성)
  스와핑 발생시 노드 안정성에 치명적

  1. 스와핑 비활성화 (시스템이 노드에만 사용) : `sudo swapoff -a` (일시적), `vim /etc/fstab` (영구적)

  2. 스와핑 최소화 (스와핑 일어날 수도) : `cat /proc/sys/vm/swappiness` `sysctl vm.swappiness=1`

  3. 루트권한없다면 elasticsearch.yml 값이용(그래도 스와핑일어남) : `bootstrap.memory_lock: true`
     `GET _nodes?filter_path=**.mlockall`을 이용해 확인

  4. memory locking requested for elasticsearch process but memory is not locked 오류나면
     vim /etc/security/limits.conf

     ```conf
     elasticsearch soft memlock unlimited
     elasticsearch hard memlock unlimited
     ```

---

- max open files 늘리기
  - `ulimit -n 81920` 일시적
  - `vi /etc/security/limits.conf` 에서 `*    soft    nofile    81920`, `*    hard    nofile    81920` 수정함
  - `ulimit -a`로 확인
- max thread 늘리기
  - `ulimit -u 81920` 일시적
  - `vi /etc/security/limits.conf` 에서 `*    soft    nproc    81920`, `*    hard    nproc    81920` 수정함



---

- 단일서버로 설정은 elasticsearch.yml 에서 설정, 클러스트 공통 설정은 _cluster/settings API



---

궁금증

- elasticsearch에서 스와핑 안하게 해야한다해서 비활성화하려하는데 한 물리머신을 노드 전용으로 사용가능하면 그리하라는데 한 물리머신안에 두 노드 있어도 그렇게 해도될까?
- 50%인 48기가를 힙메모리로 사용하려하는데 마스터와 데이터 노드 동일하게 24G씩 주는 게 나은가?





```bash
$ bin/kibana-plugin install file:///local/path/to/custom_plugin.zip
```

