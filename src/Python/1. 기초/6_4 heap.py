# 부모가 자식보다 항상 크다
# 우측 하단을 제외하고 complete하다
# 정상 작동 확인

A = ['', 2, 9, 7, 6, 5, 8]   # 여기서는 A[0]은 사용하지 않는다. A[1]부터 heap


def heap_bottomup():
    n = len(A)-1
    for i in range(int(n/2), 0, -1):    # n/2부터 1까지반복
        k = i
        v = A[k]                    # heap으로 변형전, 부모 노드
        heap = False                # 해당 노드의 서브트리의 힙 여부
        while not heap and 2*k <= n:
            j = 2*k                 # v의 왼쪽 자식노드
            if j < n:               # 자식이 2개 있을 경우,
                if A[j] < A[j+1]:   # 오른쪽 자식이 더 클경우, 오른쪽 자식으로 비교함
                    j = j+1
            if A[j] < v:            # 부모가 자식들보다 큰 경우,
                heap = True         # 해당 서브트리는 heap
            else:                   # 부모가 자식보다 작은 경우,
                A[k] = A[j]         # 해당 서브트리의 머리는 자식들중 큰 것
                k = j
        A[k] = v


print(A)
heap_bottomup()
print(A)
