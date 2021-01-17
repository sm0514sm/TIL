P = [0, 0.1, 0.2, 0.4, 0.3]
C = [[0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0]]
R = [[0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0]]


def optimalBST(P):
    for i in range(1, len(P)):
        C[i][i-1] = 0
        C[i][i] = P[i]
        R[i][i] = i
    C[len(P)][len(P)-1] = 0

    for d in range(1, len(P)-1):
        for i in range(1, len(P)-d): # 1 to 3 > 1 to 2 > 1 to 1
            j = i+d                  # 2 3    > 3
            minval = 999
            kmin = 0
            for k in range(i, j+1):# k= 1 , k= 2
                if C[i][k-1] + C[k+1][j] < minval:
                    minval = C[i][k-1] + C[k+1][j]
                    kmin = k
            R[i][j] = kmin
            sum = P[i]
            for s in range(i+1, j+1):
                sum = sum + P[s]
            C[i][j] = minval + sum
    return C[1][len(P)-1]


def OptimalTree(i, j):
    if i <= j:
        k = R[i][j]
        print(k)
        OptimalTree(i, k - 1)
        OptimalTree(k + 1, j)


print(optimalBST(P))
print(C[0])
print(C[1])
print(C[2])
print(C[3])
print(C[4])
print(C[5])
OptimalTree(1, 4)