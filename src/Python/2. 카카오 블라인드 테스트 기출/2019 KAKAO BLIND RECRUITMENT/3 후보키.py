# https://www.welcomekakao.com/learn/courses/30/lessons/42890
# https://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/
answer = 0
relation = []
success_list = []
row_cnt = 0
col_cnt = 0


def solution(rel):
    global relation, row_cnt, col_cnt
    row_cnt = len(rel)
    col_cnt = len(rel[0])
    relation = rel
    subset_while(col_cnt)
    return answer


def check(check_list):
    global relation, answer
    checkset = set()
    for rel in relation:
        tmp_list = []
        for col in check_list:
            tmp_list.append(rel[col])
        checkset.add(tuple(tmp_list))

    if len(checkset) == row_cnt:
        success_list.append(check_list)
        answer += 1


def subset_while(N):
    for i in range(1, 1 << N):
        check_list = []
        ischeckneed = True
        for j in range(N):
            if (i & 1 << j) > 0:
                check_list.append(j)
        for success in success_list:
            if not set(success) - set(check_list):
                ischeckneed = False
        if ischeckneed:
            check(check_list)


print(solution([["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"],
                ["400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]]))
# result = 2
