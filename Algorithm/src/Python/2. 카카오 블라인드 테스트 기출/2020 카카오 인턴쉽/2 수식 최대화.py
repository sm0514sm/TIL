# https://programmers.co.kr/learn/courses/30/lessons/67257
# https://tech.kakao.com/2020/07/01/2020-internship-test/


import itertools


def solution(expression):
    answer = 0
    pool = []
    if '-' in expression:
        pool.append('-')
    if '+' in expression:
        pool.append('+')
    if '*' in expression:
        pool.append('*')
    perm = list(map(''.join, itertools.permutations(pool)))

    val_list = split(pool, expression)
    exp_list = get_exp(expression)
    ans_list = []

    for per in perm:
        val_list_copy = val_list.copy()
        exp_list_copy = exp_list.copy()
        for p in per:  # 각 연산자마다
            i = 0
            while exp_list_copy and i < len(exp_list_copy):
                if p == exp_list_copy[i]:
                    val_list_copy[i] = str(eval(val_list_copy[i] + exp_list_copy[i] + val_list_copy[i + 1]))
                    del val_list_copy[i + 1]
                    del exp_list_copy[i]
                    i -= 1
                i += 1
        ans_list.append(abs(int(val_list_copy[0])))
    return max(ans_list)


def split(pool, text):
    for poo in pool:
        text = text.replace(poo, pool[0])
    return text.split(pool[0])


def get_exp(text):
    ans = []
    for t in text:
        if not t.isalnum():
            ans.append(t)
    return ans


print(solution("100-200*300-500+20"))  # 60420
print(solution("50*6-3*2"))  # 300
