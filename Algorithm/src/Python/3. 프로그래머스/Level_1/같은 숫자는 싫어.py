# 2021-02-06
# https://programmers.co.kr/learn/courses/30/lessons/12906?language=python3#

def solution(arr):
    answer = []
    last = arr[0]
    answer.append(last)
    for i in arr:
        if last != i:
            last = i
            answer.append(last)
            continue
    return answer


print(solution([1, 1, 3, 3, 0, 1, 1]))
