# https://programmers.co.kr/learn/courses/30/lessons/67259?language=python3
# https://tech.kakao.com/2020/07/01/2020-internship-test/
# import copy
#
#
# def solution(board):
#     print('------------')
#     min_val = 999999
#     DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]  # 우 하 좌 상
#     board_size = len(board)
#     visited = [[False] * board_size for i in range(board_size)]
#     for i in range(board_size):
#         for j in range(board_size):
#             visited[i][j] = True if board[i][j] == 1 else False
#     stack = [[0, 0, -1, 0, copy.deepcopy(visited), -1]]  # 행 열 방향 가격 방문여부 전방향
#     way_dir = 0
#     while stack:
#         pop = stack.pop()
#         pop_visited = pop[4]
#         pop_visited[pop[0]][pop[1]] = True
#
#         if pop[2] != -1:
#             if pop[5] == pop[2] or pop[5] == -1:
#                 pop[3] += 100
#
#             else:
#                 pop[3] += 600
#             pop[5] = pop[2]
#         else:
#             pop[2] = 0
#         way_dir = pop[2]
#         # print(pop[0], pop[1], "가격:", pop[3])
#         if pop[3] > min_val:
#             continue
#
#         if pop[0] == board_size - 1 and pop[1] == board_size - 1:
#             min_val = pop[3] if min_val > pop[3] else min_val
#             continue
#
#         # 90도 회전 가능
#         temp = [pop[0] + DIR[(way_dir + 1) % 4][0], pop[1] + DIR[(way_dir + 1) % 4][1], (way_dir + 1) % 4, pop[3], copy.deepcopy(pop_visited), pop[5]]
#         if (temp[0] < board_size and temp[1] < board_size) and (temp[0] >= 0 and temp[1] >= 0) and \
#                 not pop_visited[temp[0]][temp[1]]:  # 방문하지 않고 벽이 없으면
#             stack.append(temp)
#         # -90도 회전 가능
#         temp = [pop[0] + DIR[way_dir - 1][0], pop[1] + DIR[way_dir - 1][1], way_dir - 1, pop[3], copy.deepcopy(pop_visited), pop[5]]
#         if (temp[0] < board_size and temp[1] < board_size) and (temp[0] >= 0 and temp[1] >= 0) and \
#                 not pop_visited[temp[0]][temp[1]]:  # 방문하지 않고 벽이 없으면
#             stack.append(temp)
#         # 직진 가능
#         temp = [pop[0] + DIR[way_dir][0], pop[1] + DIR[way_dir][1], way_dir, pop[3], copy.deepcopy(pop_visited), pop[5]]
#         if (temp[0] < board_size and temp[1] < board_size) and (temp[0] >= 0 and temp[1] >= 0) and \
#                 not pop_visited[temp[0]][temp[1]]:  # 방문하지 않고 벽이 없으면
#             stack.append(temp)
#     return min_val
# 실패
def solution1(board):
    print('------------')
    min_val = 999999
    DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]  # 우 하 좌 상
    board_size = len(board)
    board[0][0] = 1
    # visited = [[[99999, []]] * board_size for i in range(board_size)]
    visited = [[[]] * board_size for i in range(board_size)]
    for i in range(board_size):
        for j in range(board_size):
            visited[i][j] = [99999, {}]
    visited[0][0] = [0, {0, 1}]  # 첫번째 칸의 비용은 0이고 우 하로 이동가능
    # visited[0][0][0] = 1

    queue = [[0, 1, 0], [1, 0, 1]]
    while queue:
        vertex = queue.pop(0)
        price = 100
        if vertex[2] in visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][1]:
            price = 100
        else:
            price = 600
        if visited[vertex[0]][vertex[1]][0] < visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][0] + price:
            continue
        elif visited[vertex[0]][vertex[1]][0] > visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][0] + price:
            visited[vertex[0]][vertex[1]][0] = visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][0] + price
            visited[vertex[0]][vertex[1]][1] = set()
            visited[vertex[0]][vertex[1]][1].add(vertex[2])
        elif visited[vertex[0]][vertex[1]][0] == visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][0] + price:  # else 도 됨
            visited[vertex[0]][vertex[1]][1].add(vertex[2])
        for i, direction in enumerate(DIR):
            if (vertex[2] + 2) % 4 == direction:
                continue
            dr = vertex[0] + direction[0]
            dc = vertex[1] + direction[1]
            if 0 <= dr < board_size and 0 <= dc < board_size and board[dr][dc] == 0:
                queue.append([dr, dc, i])
    return visited[board_size-1][board_size-1][0]

# 실패
def solution2(board):
    print('------------')
    min_val = 999999
    DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]  # 우 하 좌 상
    board_size = len(board)
    board[0][0] = 1
    visited = [[[]] * board_size for i in range(board_size)]
    for i in range(board_size):
        for j in range(board_size):
            visited[i][j] = [99999, 99999, 99999, 99999]
    visited[0][0] = [0, 0, 99999, 99999]

    queue = [[0, 1, 0], [1, 0, 1]]
    while queue:
        vertex = queue.pop(0)
        if min(visited[board_size - 1][board_size - 1]) < min(visited[vertex[0]][vertex[1]]):
            continue
        if visited[vertex[0]][vertex[1]][vertex[2]] == min(visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][vertex[2]] + 100, min(visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]]) + 600):
            continue
        if visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][vertex[2]] != 99999:
            visited[vertex[0]][vertex[1]][vertex[2]] = min(visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]][vertex[2]] + 100, min(visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]]) + 600)
        else:
            pre_min = min(visited[vertex[0] - DIR[vertex[2]][0]][vertex[1] - DIR[vertex[2]][1]])
            if visited[vertex[0]][vertex[1]][vertex[2]] > 600 + pre_min and min(visited[board_size-1][board_size-1]) > 600 + pre_min:
                visited[vertex[0]][vertex[1]][vertex[2]] = 600 + pre_min
            else:
                continue

        for i, direction in enumerate(DIR):
            if (vertex[2] + 2) % 4 == i:
                continue
            dr = vertex[0] + direction[0]
            dc = vertex[1] + direction[1]
            if 0 <= dr < board_size and 0 <= dc < board_size and board[dr][dc] == 0:
                if i != vertex[2] and min(visited[dr][dc]) + 600 <= min(visited[vertex[0]][vertex[1]]):
                    continue
                queue.append([dr, dc, i])
    return min(visited[board_size-1][board_size-1])

# 보고 좀 베낌
def solution(board):
    N = len(board)
    DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]  # 우 하 좌 상
    queue = list()
    queue.append((0, 0, -1, 0))  # r c dir cost
    visit = {(0, 0, 0): 0, (0, 0, 1): 0, (0, 0, 2): 0, (0, 0, 3): 0}
    answer = list()
    while queue:
        r, c, new_dir, cost = queue.pop(0)
        if r == N-1 and c == N-1:
            answer.append(cost)
        for d in range(4):
            nr = r + DIR[d][0]
            nc = c + DIR[d][1]
            if nr < 0 or nr >= N or nc < 0 or nc >= N or board[nr][nc]:
                continue
            new_cost = cost
            if new_dir == -1:
                new_cost += 100
            elif (new_dir + d) % 2 == 0:
                new_cost += 100
            else:
                new_cost += 600
            if visit.get((nr, nc, d)) is None or visit.get((nr, nc, d)) > new_cost:
                queue.append((nr, nc, d, new_cost))
                visit[(nr, nc, d)] = new_cost
    return min(answer)


print(solution([[0, 0, 0], [0, 0, 0], [0, 0, 0]]))  # 900
print(solution([[0, 0, 0, 0, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0, 0, 0],
                [0, 0, 0, 1, 0, 0, 0, 1], [0, 0, 1, 0, 0, 0, 1, 0], [0, 1, 0, 0, 0, 1, 0, 0],
                [1, 0, 0, 0, 0, 0, 0, 0]]))  # 3800
print(solution([[0, 0, 1, 0], [0, 0, 0, 0], [0, 1, 0, 1], [1, 0, 0, 0]]))  # 2100
print(solution([[0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 0], [0, 0, 1, 0, 0, 0], [1, 0, 0, 1, 0, 1], [0, 1, 0, 0, 0, 1],
                [0, 0, 0, 0, 0, 0]]))  # 3200
print(solution([[0, 0, 0, 0, 0], [0, 1, 1, 1, 0], [0, 0, 1, 0, 0], [1, 0, 0, 0, 1], [0, 1, 1, 0, 0]]))  # 3000
#