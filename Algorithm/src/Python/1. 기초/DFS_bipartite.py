# DFS를 이용해 bipartite 이분 정렬이 가능한 그래프인지 판단한다.
# 그래프에는 노드와 노드들이 연결된 노드들을 adjacency list로 나타낸다.

graph = {'A': ['B', 'D'],
         'B': ['A', 'C', 'E'],
         'C': ['B', 'F'],
         'D': ['A', 'E'],
         'E': ['B', 'D', 'F'],
         'F': ['C', 'E']}
color = {'A': 0,
         'B': 0,
         'C': 0,
         'D': 0,
         'E': 0,
         'F': 0}


def dfs(start, col):
    color[start] = col
    print(color)
    while True:
        if graph[start]:
            cur = graph[start].pop()
        else:
            break
        if color[start] == color[cur]:
            return False
        if color[cur] == 0 and not dfs(cur, -col):
            return False
    return True


print(dfs("A", 1))
