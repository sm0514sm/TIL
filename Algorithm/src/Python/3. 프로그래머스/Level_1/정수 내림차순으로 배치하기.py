# 2021-02-09
# https://programmers.co.kr/learn/courses/30/lessons/12933?language=python3
def solution(n):
    return int(''.join(sorted([i for i in str(n)], reverse=True)))


def solution1(n):
    return int(''.join(sorted(str(n), reverse=True)))

