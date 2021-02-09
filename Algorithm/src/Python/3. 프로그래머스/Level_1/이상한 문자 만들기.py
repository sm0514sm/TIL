# 2021-02-09
# https://programmers.co.kr/learn/courses/30/lessons/12930?language=python3
def solution(s):
    answer = []
    for word in s.split(" "):
        answer.append(''.join([cha.upper() if i % 2 == 0 else cha.lower() for i, cha in enumerate(word)]))
    return ' '.join(answer)


print(solution('try hello world'))
print(solution('TRY HELLO WORLD'))
print(solution(' tRy  he334!@#$$%#@^lLO wOrLd'))
print(solution('tRy t t t t t'))
