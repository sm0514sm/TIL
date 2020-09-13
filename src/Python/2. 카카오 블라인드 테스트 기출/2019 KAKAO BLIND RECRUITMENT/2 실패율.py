# https://www.welcomekakao.com/learn/courses/30/lessons/42889
# https://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/


def solution(N, stages):
    failcount = [0] * (N + 1)
    for stage in stages:
        if stage > N:
            continue
        failcount[stage] += 1
    faillist = []
    stage_cnt = len(stages)
    for stage, cnt in enumerate(failcount):
        if stage == 0:
            continue
        faillist.append((stage, cnt/stage_cnt if stage_cnt != 0 else 0))
        stage_cnt -= cnt
    faillist = sorted(faillist, key=lambda fail: -fail[1])

    answer = []
    for fail in faillist:
        answer.append(fail[0])
    return answer


# print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
# print(solution(4, [4, 4, 4, 4, 4]))
# print(solution(1, [1, 1, 1, 1, 2]))
print(solution(500, [1, 1, 1, 1]))
