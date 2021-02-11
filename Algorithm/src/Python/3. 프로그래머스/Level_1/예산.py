# 2021-02-11
# https://programmers.co.kr/learn/courses/30/lessons/12982?language=python3
def solution(d, budget):
    d.sort()
    answer = 0
    while d and budget > 0:
        pop = d.pop(0)
        if budget - pop >= 0:
            budget -= pop
            answer += 1
        else:
            break
    return answer


print(solution([1, 3, 2, 5, 4], 9))
print(solution([2, 2, 3, 3], 10))
