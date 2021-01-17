# 코인 줍는데 인접한거 못줍고 최대한 비싸게 줍기, F의 마지막이 최종결과


def coin_row(C):
    F = []
    F.append(0)
    F.append(C[1])
    for i in range(2, len(C)):
        F.append(max(C[i]+F[i-2], F[i-1]))
    return F


C = [0, 10, 5, 3, 2, 7, 2, 7, 13]
print(coin_row(C))

