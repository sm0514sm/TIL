# 정렬된 배열로부터 특정한 값을 찾아냄

A = [3, 14, 27, 31, 39, 42, 55, 70, 74, 81, 85, 93, 98]


def binary_search(k):
    l = 0
    r = len(A)-1
    while l <= r:
        m = int((r+l)/2)
        if k == A[m]:
            return True
        elif k > A[m]:
            l = m+1
        elif k < A[m]:
            r = m-1
    return False


print(binary_search(70))