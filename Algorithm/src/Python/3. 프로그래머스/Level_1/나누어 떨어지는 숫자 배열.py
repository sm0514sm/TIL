# 2021-02-06
# https://programmers.co.kr/learn/courses/30/lessons/12910?language=python3

def solution(arr, divisor):
    answer = [i for i in arr if i % divisor == 0]
    return sorted(answer) or [-1]


print(solution([5, 9, 7, 10], 5))
