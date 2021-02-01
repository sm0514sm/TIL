# 2021-02-01
# https://programmers.co.kr/learn/courses/30/lessons/64061?language=python3

def solution(board: list[list], moves: list[int]) -> int:
    answer: int = 0
    moves = [i - 1 for i in moves]
    size = len(board)
    queue = list()
    for move in moves:
        for height in range(size):
            if board[height][move] == 0:
                continue
            if queue and queue[-1] == board[height][move]:
                answer += 2
                queue.pop()
            else:
                queue.append(board[height][move])
            board[height][move] = 0
            break
    return answer


print(solution([[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]],
               [1, 5, 3, 5, 1, 2, 1, 4]))  # 4
