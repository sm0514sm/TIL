# 2021-02-02
# https://programmers.co.kr/learn/courses/30/lessons/72410
import re


def solution(new_id):
    new_id = new_id.lower()
    new_id = re.sub(r'[^0-9a-z-_.]', '', new_id)
    new_id = re.sub(r'[.]+', '.', new_id)
    if new_id[0] == '.':
        new_id = new_id[1:]
    if new_id and new_id[-1] == '.':
        new_id = new_id[:-1]

    # 5
    if not new_id:
        new_id += 'a'

    # 6
    new_id = new_id[:15]
    if new_id[-1] == '.':
        new_id = new_id[:-1]

    # 7
    while len(new_id) <= 2:
        new_id += new_id[-1]

    return new_id


print(solution("...!@BaT#*..y.abcdefghijklm"))
print(solution("=.="))
