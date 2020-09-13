import itertools

char_dict = {}
ans = 999999

# 여기가 문제인듯
def movecnt(fro, to):
    if fro[0] == to[0] and fro[1] == to[1]:
        return 0
    elif fro[0] == to[0] or fro[1] == to[1]:
        return 1
    elif to[0] == 0 or to[0] == 3 or to[1] == 0 or to[1] == 3:
        return 2
    elif abs(fro[0] - to[0]) + abs(fro[1] - to[1]) == 4:
        return 4
    else:
        return 2


def go(start, way, dept, tmp, cnt):
    global ans
    if len(way) == dept:
        ans = min(ans, cnt)
        return
    apnt, bpnt = char_dict[way[dept]]
    if tmp:  # a먼저
        cnt += movecnt([start[0], start[1]], apnt)
        start = apnt
        cnt += movecnt([start[0], start[1]], bpnt)
        start = bpnt
    else:
        cnt += movecnt([start[0], start[1]], bpnt)
        start = bpnt
        cnt += movecnt([start[0], start[1]], apnt)
        start = apnt
    go(start, way, dept + 1, True, cnt)
    go(start, way, dept + 1, False, cnt)


def solution(board, r, c):
    char_list = []
    global char_dict, ans
    ans = 999999
    char_dict = {}
    for i in range(4):
        for j in range(4):
            if board[i][j] != 0:
                char_list.append([i, j])
                if not char_dict.get(board[i][j]):
                    char_dict[board[i][j]] = [[i, j]]
                else:
                    char_dict[board[i][j]].append([i, j])
    answer = len(char_list)

    for way in list(itertools.permutations([i+1 for i in range(len(char_list)//2)])):
        cnt = 0
        tr = r
        tc = c

        go([tr, tc], way, 0, True, cnt)
        go([tr, tc], way, 0, False, cnt)

    return answer + ans


print(solution([[1,0,0,3],[2,0,0,0],[0,0,0,2],[3,0,1,0]], 1, 0))  #	14
print(solution([[3,0,0,2],[0,0,1,0],[0,1,0,0],[2,0,0,3]], 0, 1))  #	16