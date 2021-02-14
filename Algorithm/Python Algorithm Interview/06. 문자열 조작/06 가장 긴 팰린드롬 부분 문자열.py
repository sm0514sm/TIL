# 2021-01-26
# 리트코드 5. Longest Palindrome Substring
# https://leetcode.com/problems/longest-palindromic-substring
# Q: 가장 긴 팰린드롬 부분 문자열 찾아내라
def longest_palindrome(s: str) -> str:
    # left ~ right까지 팰린드롬인지 확인 후 확장
    def expand(left, right) -> str:
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left + 1: right]

    # 예외 처리
    if len(s) < 2 or s == s[::-1]:
        return s

    result = ''
    for i in range(len(s) - 1):
        # 짝수, 홀수일 때 각각 팰린드롬 판단
        result = max(result, expand(i, i + 1), expand(i, i + 2), key=len)
    return result


print(longest_palindrome("babad"))
print(longest_palindrome("cbbd"))
print(longest_palindrome("bb"))
