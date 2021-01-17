A = [[0, 3, 999, 2, 6],
     [5, 0, 4, 2, 999],
     [999, 999, 0, 5, 999],
     [999, 999, 1, 0, 4],
     [5, 999, 999, 999, 0]]


def floyd(A):
    D = A
    n = len(A)-1
    for k in range(0, n+1):
        for i in range(0, n+1):
            for j in range(0, n+1):
                D[i][j] = min(D[i][j], D[i][k] + D[k][j])
    return D


K = floyd(A)
print(K[0])
print(K[1])
print(K[2])
print(K[3])
print(K[4])
