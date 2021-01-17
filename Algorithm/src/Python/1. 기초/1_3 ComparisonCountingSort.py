A = [60, 35, 81, 98, 14, 47]
Count = [0, 0, 0, 0, 0, 0]
S = [0, 0, 0, 0, 0, 0]
n = len(A)
for i in range(0, n - 1):
    for j in range(i + 1, n):
        if A[i] < A[j]:
            Count[j] += 1
        else:
            Count[i] += 1
for i in range(0, n):
    S[Count[i]] = A[i]

print(S)