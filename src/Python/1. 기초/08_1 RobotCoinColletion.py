
C = [[0, -10, 0, 1, 0, 0],
     [1, 0, 0, -10, 1, 0],
     [0, 1, 0, -10, 1, 1],
     [0, 0, 0, 1, 0, 1],
     [-10, -10, -10, 0, 1, 0]]
P = [[0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0]]


def robot_coin_collection(C, F):
    F[0][0] = C[0][0]
    for j in range(1, 6):
        F[0][j] = F[0][j-1]+C[0][j]
    for i in range(1, 5):
        F[i][0] = F[i-1][0] + C[i][0]
        for j in range(1, 6):
            F[i][j] = max(F[i-1][j], F[i][j-1])+C[i][j]
    return F


F = robot_coin_collection(C, P)
print(F[0])
print(F[1])
print(F[2])
print(F[3])
print(F[4])

