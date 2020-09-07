# 주어진 배열 A로부터 k개 만큼 뽑은 조합의 목록을 출력

A = [1, 2, 3, 4, 5]

set1 = []


def combi(k, index):
    if k == 0:
        print(set1)
    elif index == len(A):
        return
    else:
        set1.append(A[index])
        combi(k-1, index + 1)
        set1.pop()
        combi(k, index + 1)


combi(3, 0)
