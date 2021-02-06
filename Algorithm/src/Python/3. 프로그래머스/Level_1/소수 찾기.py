# 2021-02-07
# https://programmers.co.kr/learn/courses/30/lessons/12921?language=python3

def is_sosu(num):
    for i in range(3, int(num ** 0.5) + 1, 2):
        if num % i == 0:
            return False
    return True


def solution(n):
    ans = 1
    for num in range(3, n + 1, 2):
        if is_sosu(num):
            ans += 1
    return ans


def solution2(n):
    num = set(range(2, n + 1))

    for i in range(2, n + 1):
        if i in num:
            num -= set(range(i * 2, n + 1, i))
    return len(num)


print(solution(9))
print(solution2(1000000))
