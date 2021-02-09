# 2021-02-09
# https://programmers.co.kr/learn/courses/30/lessons/12928?language=python3

def solution(n):
    answer = set()
    for num in range(1, int(n ** 0.5) + 1):
        if n % num == 0:
            answer.add(num)
            answer.add(n // num)
    return sum(answer)


print(solution(5))
print(solution(12))
