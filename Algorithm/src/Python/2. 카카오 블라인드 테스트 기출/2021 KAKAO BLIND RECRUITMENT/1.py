def solution(new_id):
    # 1
    new_id = new_id.lower()

    # 2
    tmp_id = ""
    for c in new_id:
        if c.isalnum() or c == "-" or c == "_" or c == ".":
            tmp_id += c
    new_id = tmp_id

    # 3
    for i in range(15, 0, -1):
        tmp = '.' * i
        new_id = new_id.replace(tmp, ".")

    # 4
    if new_id[0] == '.':
        new_id = new_id[1:]
    if len(new_id) != 0 and new_id[-1] == '.':
        new_id = new_id[:-1]

    # 5
    if len(new_id) == 0:
        new_id = 'a'

    # 6
    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[-1] == '.':
            new_id = new_id[:-1]

    # 7
    while len(new_id) <= 2:
        new_id += new_id[-1]

    return new_id


print(solution("...!@BaT#*..y.abcdefghijklm"))  # "bat.y.abcdefghi"
print(solution("z-+.^."))  # "z--"
print(solution("=.="))  # "aaa"
print(solution("123_.def"))  # "123_.def"
print(solution("abcdefghijklmn.p"))  # "abcdefghijklmn"
