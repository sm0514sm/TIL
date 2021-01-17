# polynomial을 푸는 것
# ex f(x) = 2x^4 - x^3 + 3x^2 + x - 5
# 이때 f(3)을 구하시오.

P = [-5, 1, 3, -1, 2]   # P[0]은 상수, P[4]는 4차항


# f(x) = ?
def horner(x):
    n = len(P)-1    # 마지막 항 차수, 여기선 4
    p = P[n]
    for i in range(n-1, -1, -1):  # i from n-1 to 0
        p = p*x + P[i]
    return p


print(horner(3))