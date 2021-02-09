# 2021-02-09
# https://programmers.co.kr/learn/courses/30/lessons/12935?language=python3
def solution(arr):
    arr.remove(min(arr))
    return arr or [-1]


print(solution([4, 3, 2, 1]))
