# 2021-02-12
# https://programmers.co.kr/learn/courses/30/lessons/62048?language=python3
def gcd(a, b):
    return b if (a == 0) else gcd(b % a, a)


def solution(w, h):
    # 최대 공약수
    w_set, h_set = set(), set()
    for i in range(1, int(w ** 0.5 + 1)):
        if w % i == 0:
            w_set.add(i)
            w_set.add(w // i)
    for i in range(1, int(h ** 0.5 + 1)):
        if h % i == 0:
            h_set.add(i)
            h_set.add(h // i)
    gcd_num = gcd(w, h)

    minimum = min(w, h) // gcd_num
    maximum = max(w, h) // gcd_num
    return w * h - (minimum + maximum - 1) * gcd_num  # 왜그런지 생각해보라


print(solution(8, 12))  # 80
print(solution(3, 5))  #
print(solution(6, 10))  #
print(solution(9, 15))
print(solution(100000000, 999999999))  # 99999998800000002

#   1  2  3  4  5  6  7  8  9  10
# 1 1  2  3  4  5  6  7  8  9  10
# 2    2  4  4  6  6  8
# 3       3  6  7
# 4          4
# 5             5
# 6                6
# 7
# 8
# 9
# 10
