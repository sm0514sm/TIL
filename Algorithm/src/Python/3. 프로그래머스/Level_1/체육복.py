# 2021-02-03
# https://programmers.co.kr/learn/courses/30/lessons/42862?language=python3

def solution(n, lost, reserve):
    intersection = set(lost) & set(reserve)
    lost = list(set(lost) - intersection)
    reserve = list(set(reserve) - intersection)
    for los in lost[:]:
        if los > 1 and los - 1 in reserve:
            lost.remove(los)
            reserve.remove(los - 1)
        elif los < n and los + 1 in reserve:
            lost.remove(los)
            reserve.remove(los + 1)
    return n - len(lost)


print(solution(5, [2, 4], [1, 3, 5]))
print(solution(5, [2, 4], [3]))
print(solution(3, [3], [1]))
print(solution(3, [2, 3], [1, 2]))
print(solution(	5, [4, 5], [3, 4]))
