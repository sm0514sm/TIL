# 2021-02-03
# https://programmers.co.kr/learn/courses/30/lessons/12903?language=python3

def solution(s):
    return s[len(s) // 2] if len(s) % 2 == 1 else s[len(s) // 2 - 1:len(s) // 2 + 1]

