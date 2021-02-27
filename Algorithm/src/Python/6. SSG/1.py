# grid[I][j] = 0 은 물을, grid[I][j] = 1 은 땅이라고 표현하는 Grid가 있습니다. Grid의 Cell들은 오직 수평, 수직으로만 연결됩니다 (대각선 없음)
# Grid는 물로 완전히 둘러쌓여 있으며 하나 이상 연결되어 있거나 연결되어 있지 않은 육지로 구성되어 있습니다.
# 섬에는 물이 없고 하나의 Cell은 길이가 1인 정사각형 형태를 띄고 있습니다.
# Grid는 직사각형이고 너비와 높이는 100을 넘지 않습니다.
# 섬의 둘레를 계산하는 코드를 만드세요.
from collections import deque


def solution(grid: list) -> int:
    width, height = len(grid[0]), len(grid)
    direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    answer = 0

    def bfs(r, c):
        queue = deque()
        queue.append([r, c])
        grid[r][c] = 2
        perimeter = 0
        while queue:
            pr, pc = queue.popleft()
            for vertical, horizon in direction:
                find_r, find_c = pr + vertical, pc + horizon
                if not (0 <= find_r < height) or not (0 <= find_c < width) or grid[find_r][find_c] == 0:
                    perimeter += 1
                elif grid[find_r][find_c] == 1:
                    grid[find_r][find_c] = 2
                    queue.append([find_r, find_c])
        return perimeter

    # grid[i][j] = 0: 물, 1: 방문하지 않은 땅, 2: 방문한 땅
    for i, row in enumerate(grid):
        for j, cell in enumerate(row):
            if cell != 1:  # 방문하지 않은 땅이 아닌 경우
                continue
            answer += bfs(i, j)

    return answer


print(solution([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]))
print(solution([[0, 1, 0, 0], [1, 0, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]))
print(solution([[0, 1, 0, 0], [1, 0, 1, 0], [0, 0, 0, 0], [1, 1, 0, 0]]))
print(solution([[0, 1, 0, 0], [1, 1, 1, 0], [0, 0, 0, 0], [1, 1, 0, 0]]))
print(solution([[1, 1, 1, 1], [1, 0, 0, 1], [1, 0, 0, 1], [1, 1, 1, 1]]))   # 24
print(solution([[1, 1, 1, 1], [1, 0, 0, 1], [1, 0, 0, 1], [1, 0, 0, 1], [1, 1, 1, 1]]))   # 28
print(solution([[1, 1, 1, 1, 1], [1, 0, 0, 0, 1], [1, 0, 0, 0, 1], [1, 1, 1, 1, 1]]))   # 28
