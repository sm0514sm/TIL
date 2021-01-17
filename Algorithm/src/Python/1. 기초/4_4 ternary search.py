# 미작동 수정 필요

A = [3, 5, 11, 24, 46, 78]
n = len(A)


def ternary(k, low=0, high=n-1):
    print(str(low)+": low")
    print(str(high) + ": high")
    if n == 1:
        if A[0] == k:
            return True
        else:
            return False
    else:
        while low < high:
            left = int((2 * low + high)/3)
            right = int((low + 2 * high)/3)

            if A[left] == k:
                return True
            elif A[right] == k:
                return True
            elif A[left] > k:
                if ternary(k, low, left-1):
                    return True
            elif A[right] < k:
                if ternary(k, right, high):
                    return True
            else:
                if ternary(k, left+1, right-1):
                    return True
        return False


print(ternary(11))
print(ternary(12))
print(ternary(23))
print(ternary(24))