# 2021-01-21
# 리트코드 125. Valid Palindrome

# Q: 주어진 문자열이 팰린드롬인지 확인하라. 대소문자 구분X, 영문자와 숫자만을 대상
import re


def my_solution(s: str) -> bool:
    s = s.lower()
    l_pnt = 0
    r_pnt = len(s) - 1
    while l_pnt < r_pnt:
        while not s[l_pnt].isalnum():
            l_pnt += 1
        while not s[r_pnt].isalnum():
            r_pnt -= 1
        if s[l_pnt] != s[r_pnt]:
            return False
        l_pnt += 1
        r_pnt -= 1
    return True


def solution1(s: str) -> bool:
    strs = []
    for char in s:
        if char.isalnum():
            strs.append(char.lower())

    # 팰린드롬 여부 확인
    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            return False
    return True


# 슬라이싱 방식은 매우 빠르다!
# reverse() 메서드보다도 5배 빠르다.
def solution2(s: str) -> bool:
    s = s.lower()
    # 정규식으로 불필요한 문자 필터링
    s = re.sub("[^a-z0-9]", '', s)

    # 전처리 후 문자열과 역문자열 같은지 판단
    return s == s[::-1]


print(my_solution("A man, a plan, a canal: Panama"))   # true
print(my_solution("race a car"))   # true
print(solution1("A man, a plan, a canal: Panama"))   # true
print(solution1("race a car"))   # true
print(solution2("A man, a plan, a canal: Panama"))   # true
print(solution2("race a car"))   # true
