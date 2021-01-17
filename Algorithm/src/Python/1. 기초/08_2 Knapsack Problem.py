Weight = [0, 3, 2, 1, 4, 5]
Values = [0, 25, 20, 15, 40, 50]
F = [[0, 0, 0, 0, 0, 0, 0],
     [0, -1, -1, -1, -1, -1, -1],
     [0, -1, -1, -1, -1, -1, -1],
     [0, -1, -1, -1, -1, -1, -1],
     [0, -1, -1, -1, -1, -1, -1],
     [0, -1, -1, -1, -1, -1, -1]]


# up-bottom 구하기
def MFK(i, j):
    if F[i][j] < 0:
        if j < Weight[i]:
            value = MFK(i-1, j)
        else:
            value = max(MFK(i-1, j), Values[i]+MFK(i-1, j-Weight[i]))
        F[i][j] = value
    return F[i][j]


# bottom-up 구하기
def DPK(W):
    for i in range(1, len(Weight)):
        for j in range(1, W+1):
            if j >= Weight[i]:
                F[i][j] = max(F[i-1][j], Values[i] + F[i-1][j-Weight[i]])
            else:
                F[i][j] = F[i-1][j]
    return F


# 아이템 목록 구하기
def OptimalKnapsack(W):
    j = W
    L = []
    for i in range(len(Weight)-1, 0, -1):
        if F[i][j] > F[i-1][j]:
            L.append(i)
            j = j - Weight[i]
    return L


MFK(5, 6)
# DPK(6)
print(OptimalKnapsack(6))
print(F[0])
print(F[1])
print(F[2])
print(F[3])
print(F[4])
print(F[5])