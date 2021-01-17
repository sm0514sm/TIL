import copy


def solution(n, edges):
    answer = []
    mmap = [[0] * n for _ in range(n)]
    map_copy = []
    mustcnt = n / 3

    def bfs(param):
        visited = [False] * n
        cnt = 0
        queue = [param]
        while queue:
            pop = queue.pop()
            visited[pop] = True
            cnt += 1
            for ii, v in enumerate(map_copy[pop]):
                if v == 1 and not visited[ii]:
                    queue.append(ii)
        return cnt

    for edge in edges:
        mmap[edge[0]][edge[1]] = 1
        mmap[edge[1]][edge[0]] = 1
    for i, edge in enumerate(edges):
        map_copy = copy.deepcopy(mmap)
        map_copy[edge[0]][edge[1]] = 0
        map_copy[edge[1]][edge[0]] = 0
        if bfs(edge[0]) % mustcnt != 0 or bfs(edge[1]) % mustcnt != 0:
            continue
        answer.append(i)

    return answer



print(solution(9, [[0,2],[2,1],[2,4],[3,5],[5,4],[5,7],[7,6],[6,8]]))  # [2,5]