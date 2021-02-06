# 2021-02-07
# https://programmers.co.kr/learn/courses/30/lessons/12926?language=python3

def solution(s, n):
    upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    lower = "abcdefghijklmnopqrstuvwxyz"
    answer = ''
    for ss in s:
        if ss == ' ':
            answer += ss
            continue
        ss = upper[(upper.index(ss) + n) % len(upper)] if ss.isupper() else lower[(lower.index(ss) + n) % len(lower)]
        answer += ss
    return answer


print(solution("a B z", 4))
