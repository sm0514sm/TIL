# 2021-02-09
# https://programmers.co.kr/learn/courses/30/lessons/12934?language=python3
def solution(n):
    sqrt = n ** 0.5
    if sqrt == int(sqrt):
        return int((sqrt + 1) ** 2)
    return -1


print(solution(121))
print(solution(3))
