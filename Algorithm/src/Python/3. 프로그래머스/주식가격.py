# https://programmers.co.kr/learn/courses/30/lessons/42584?language=python3
# 틀림
def solution(prices):
    answer = [0 for _ in range(len(prices))]
    stack = []
    for i, price in enumerate(prices):
        if not stack or stack[len(stack) - 1][1] < price:
            stack.append((i, price))
            continue

        while stack and stack[len(stack) - 1][1] > price:
            answer[i-1] = i - stack[len(stack) - 1][0]
            stack.pop()
        stack.append((i, price))
    while stack:
        answer[stack[0][0]] = len(prices) - 1 - stack[0][0]
        stack.pop(0)

    return answer


print(solution([1, 2, 3, 2, 3]))  # [4, 3, 1, 1, 0]