# 2021-02-13
# https://programmers.co.kr/learn/courses/30/lessons/12899?language=python3
def find(start, n, end):
    div = (end - start + 1) // 3
    if div == 1:
        if start == n:
            return "1"
        elif start + 1 == n:
            return "2"
        elif start + 2 == n:
            return "4"
    if start <= n <= start + div - 1:
        return "1" + find(start, n, start + div - 1)
    elif start + div <= n <= start + div * 2 - 1:
        return "2" + find(start + div, n, start + div * 2 - 1)
    elif start + div * 2 <= n <= end:
        return "4" + find(start + div * 2, n, end)


def solution(n):
    a = 3
    number = 0
    while number > n or n > number + a:
        number += a
        a *= 3
    return find(number + 1, n, number + a)


# print(solution(1))   # 1
# print(solution(2))   # 2
# print(solution(3))   # 4
# print(solution(4))   # 11
# print(solution(5))   # 12
# print(solution(6))   # 14
# print(solution(7))   # 21
# print(solution(8))   # 22
# print(solution(9))   # 24
print(solution(10))  # 41
print(solution(11))  # 42
print(solution(12))  # 44
print(solution(13))  # 111
print(solution(31))  # 111
print(solution(34))  # 111
print(solution(38))  # 111
print(solution(40))  # 111

# 1  1
# 2  2
# 3  4
# 4  11
# 5  12
# 6  14
# 7  21
# 8  22
# 9  24
# 10  41
# 11  42
# 12  44
# 13  111
# 22  211
# 31  411
# 34  421
# 37  441
# 38  442
# 39  444
# 40  1111
