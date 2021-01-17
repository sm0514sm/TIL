
A = [7, 6, 1, 2, 4, 73]
n = len(A)

print(A)


def insertion_sort():
    j = 0
    for i in range(1, n-1+1):
        j = i-1
        v = A[i]  # v까지는 정렬되게 함 unsorted, sorted의 기준
        # v까지의 위치를 정렬시킴
        while j >= 0 and A[j] > v:
            A[j+1] = A[j]
            j = j-1
        A[j+1] = v
        print(A)

insertion_sort()
print(A)