# 2021-02-10
# https://programmers.co.kr/learn/courses/30/lessons/12940?language=python3
def solution(n, m):
    def get_divisor(numb):
        divisor = set()
        for num in range(1, int(numb ** 0.5) + 1):
            if numb % num == 0:
                divisor.add(numb // num)
                divisor.add(num)
        return divisor

    gcd = max(get_divisor(n) & get_divisor(m))
    lcm = n * m // gcd
    return [gcd, lcm]


print(solution(10, 25))
