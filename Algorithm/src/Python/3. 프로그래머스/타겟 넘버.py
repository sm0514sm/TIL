# https://programmers.co.kr/learn/courses/30/lessons/43165


def solution(numbers, target):
    if not numbers:
        if target == 0:
            return 1
        else:
            return 0
    return solution(numbers[1:], target - numbers[0]) + solution(numbers[1:], target + numbers[0])


print(solution([1], 1))  # 5
