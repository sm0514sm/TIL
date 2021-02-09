# 2021-02-09
# https://programmers.co.kr/learn/courses/30/lessons/12931?language=python3
def solution(n):
    return sum(int(num) for num in (' '.join(str(n)).split()))


def solution1(n):
    return sum(int(num) for num in str(n))


print(solution("123"))
print(solution1("123"))
