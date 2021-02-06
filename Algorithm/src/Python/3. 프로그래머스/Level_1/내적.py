# 2021-02-07
# https://programmers.co.kr/learn/courses/30/lessons/70128?language=python3

def solution(a, b):
    ans = 0
    for i in range(len(a)):
        ans += a[i] * b[i]
    return ans


def solution2(a, b):
    return sum([x * y for x, y in zip(a, b)])


print(solution([1, 2, 3, 4], [-3, -1, 0, 2]))
