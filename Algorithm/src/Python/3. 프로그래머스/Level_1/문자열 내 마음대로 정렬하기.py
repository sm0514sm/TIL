# 2021-02-06
# https://programmers.co.kr/learn/courses/30/lessons/12915?language=python3


def solution(strings, n):
    return sorted(strings, key=lambda string: (string[n], string))


print(solution(["abce", "abcd", "cdx"], 2))
