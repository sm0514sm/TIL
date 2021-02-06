# 2021-02-07
# https://programmers.co.kr/learn/courses/30/lessons/12922?language=python3

def solution(n):
    return "수박" * (n // 2) if n % 2 == 0 else "수박" * (n // 2) + "수"


def solution2(n):
    return ("수박" * n)[:n]


print(solution2(3))
