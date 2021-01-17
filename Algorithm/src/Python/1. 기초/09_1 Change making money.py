def change_making(n, D):
    C = []
    for i in range(0, len(D)):
        C.append(int(n/D[i]))
        n = n % D[i]
    if n == 0:
        return C
    else:
        return "no solution"


D = [1000, 500, 100]
print(change_making(1800, D))