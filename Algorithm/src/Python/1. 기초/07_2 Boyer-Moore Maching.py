# 구현 실패

table = {'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0,
         'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't': 0, 'u': 0, 'v': 0, 'w': 0, 'x': 0, 'y': 0, 'z': 0, ' ': 0}


def ShiftTable(P):
    for i, k in enumerate(table):
        table[k] = len(P)
    for j in range(len(P)-1):
        table[P[j]] = len(P)-1-j


def HorspoolMatching(P, T):
    ShiftTable(P)
    i = len(P)-1
    while i <= len(T)-1:
        k = 0
        while k <= len(P)-1 and P[len(P)-1-k] == T[i-k]:
            k = k+1
        if k == len(P):
            return i - len(P) + 1
        else:
            d1 = max(table[T[i]]-k, 1)

            i = i + table[T[i]]
    return -1


T = "jim saw me in a barbershop"
P = "saw"

print(HorspoolMatching(P, T))