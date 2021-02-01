# 2021-01-26
# 리트코드 5. Longest Palindrome Substring

# Q: 애너그램 단위로 그룹핑하라  You can return the answer in any order.
def my_solution(text: str) -> str:
    max_num, max_key = 0, text[0]
    for i in range(len(text)):
        cnt = 0
        while i - cnt >= 0 and i + cnt < len(text) and text[i-cnt] == text[i+cnt]:
            cnt += 1
        if max_num < (cnt-1)*2 + 1:
            max_num = (cnt-1) * 2 + 1
            max_key = text[i-cnt+1:i+cnt]

        cnt = 0
        max_num = 0
        while i - cnt >= 0 and i + cnt + 1 < len(text) and text[i-cnt] == text[i+cnt + 1]:
            cnt += 1
        if max_num < cnt*2:
            max_num = cnt*2
            max_key = text[i-cnt+1:i+cnt+1]
    return max_key


# print(my_solution("babad"))
# print(my_solution("cbbd"))
print(my_solution("bb"))
