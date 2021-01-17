# BFS를 이용해 bipartite 이분 정렬이 가능한 그래프인지 판단한다.
# 그래프에는 노드와 노드들이 연결된 노드들을 adjacency list로 나타낸다.

graph = {'A': ['B', 'C'],
         'B': ['A', 'D'],
         'C': ['A', 'B', 'D'],
         'D': ['B', 'C']}
color = {'A': 0,
         'B': 0,
         'C': 0,
         'D': 0}
Q = []


def bfs(start, col):
    color[start] = col
    Q.insert(0, start)
    print(color)
    while Q:
        cur = Q.pop()
        while graph[cur]:
            next = graph[cur].pop()
            if color[next] == 0:
                color[next] = -color[cur]
                Q.insert(0, next)
            if color[next] == color[cur]:
                return False
    return True


print(bfs("A", 1))
