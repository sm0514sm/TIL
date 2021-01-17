# partition을 이용한 정렬

A = [5, 3, 1, 9, 8, 2, 4, 7]


def lomutopartition(l, r):
    p = A[l]                        # partition할 값 pivot
    s = l                           # partition 위치
    for i in range(l+1, r):
        if A[i] < p:
            s = s+1
            A[s], A[i] = A[i], A[s]
    A[l], A[s] = A[s], A[l]
    return s


def quicksort(l=0, r=len(A)):
    if l < r:
        s = lomutopartition(l, r)
        print(A)
        quicksort(l, s)
        quicksort(s+1, r)


print(A)
quicksort()
print(A)