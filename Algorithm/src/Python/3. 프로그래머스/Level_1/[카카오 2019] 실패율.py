# 2021-02-12
# https://programmers.co.kr/learn/courses/30/lessons/42889?language=python3
def solution(N, stages):
    stage_list = [0 for _ in range(N + 1)]
    for stage in stages:
        stage_list[stage - 1] += 1
    length = len(stages)
    fail_list = [[i + 1, 0.0] for i in range(N)]
    for i in range(len(stage_list) - 1):
        if length == 0:
            continue
        fail_list[i][1] = stage_list[i] / length
        length -= stage_list[i]
    fail_list.sort(key=lambda k: k[1], reverse=True)

    return [row[0] for row in fail_list]


# print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(3, [1, 1, 1]))
