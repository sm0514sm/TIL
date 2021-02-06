# 2021-02-06
# https://programmers.co.kr/learn/courses/30/lessons/12912?language=python3

def solution(a, b):
    return sum(range(a, b + 1)) if a <= b else sum(range(b, a + 1))


print(solution(3, 5))
print(solution(3, 3))
print(solution(5, 3))
