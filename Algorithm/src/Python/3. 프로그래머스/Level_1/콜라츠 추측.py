# 2021-02-11
# https://programmers.co.kr/learn/courses/30/lessons/12943?language=python3
def solution(num):
    answer = 0
    while num != 1:
        if num % 2 == 0:
            num //= 2
            answer += 1
        else:
            num = num * 3 + 1
            answer += 1
    return answer if answer <= 500 else -1


print(solution(6))
print(solution(16))
print(solution(626331))
