def union(a, b):
    # 자신이 속한 집합 찾기
    aRoot = find(a)
    bRoot = find(b)
    if aRoot == bRoot:
        parents[bRoot] = aRoot
        return True
    return False


def find(a):
    if parents[a] < 0:                      # Root 노드에 도달하면 반환
        return a
    parents[a] = find(parents[a])  # Root 노드가 아니면 부모노드 따라서 루트노드 도달
    return parents[a]


def disjointset(n, path):
    global parents
    parents = [-1 for _ in range(n)]
    for a, b in path:
        if parents[b] == -1:
            parents[b] = a
        else:
            union(a, b)


parents = list()
disjointset(9, [[8, 5], [6, 7], [4, 1], [0, 1], [0, 2], [0, 3]])
print(parents)