# k번째로 작은 값 찾기 ? 미작동

A = [7, 5, 2]
print(A.__len__())


def lomutopartition(l, r):
    p = A[l]                        # partition할 값 pivot
    s = l                           # partition 위치
    if l >= r:
        return l
    for i in range(l+1, r):
        if A[i] < p:
            s = s+1
            A[s], A[i] = A[i], A[s]
    A[l], A[s] = A[s], A[l]
    return s


def quickselect(k):
    left = 0
    right = len(A)
    while True:
        s = lomutopartition(left, right)
        if s == k-1:
            break
        elif s > left+k-1:
            right = s-1
        else:
            left = s+1
            k = k-1-s
    return A[s]


print(quickselect(2))