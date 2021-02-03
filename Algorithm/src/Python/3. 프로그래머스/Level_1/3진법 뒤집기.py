# 2021-02-03
# https://programmers.co.kr/learn/courses/30/lessons/68935?language=python3

def solution(n: int):
    ans = ""
    while n // 3 != 0:
        ans += str(n % 3)
        n //= 3
    ans += str(n % 3)
    ans = str(int(ans))[::]
    return int(ans, 3)


print(solution(45))
print(solution(125))
