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

