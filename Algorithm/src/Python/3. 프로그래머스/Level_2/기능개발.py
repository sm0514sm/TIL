# 2021-02-13
# https://programmers.co.kr/learn/courses/30/lessons/42586?language=python3
import math


def solution(progresses, speeds):
    print(list(zip(progresses, speeds)))
    progresses = [100 - progress for progress in progresses]
    days = []
    for i in range(len(progresses)):
        days.append(math.ceil(progresses[i] / speeds[i]))
    max_day = days[0]
    count = 1
    answer = []
    for i in range(1, len(days)):
        if days[i] <= max_day:
            count += 1
        else:
            max_day = days[i]
            answer.append(count)
            count = 1
    answer.append(count)

    return answer


print(solution([93, 30, 55], [1, 30, 5]))
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))
