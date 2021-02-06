# 2021-02-06
# https://programmers.co.kr/learn/courses/30/lessons/12916?language=python3

def solution(s):
    answer = True
    p = 0
    y = 0
    for i in s.lower():
        if i == 'p':
            p += 1
        elif i == 'y':
            y += 1
    return True if p == y else False