# https://programmers.co.kr/learn/courses/30/lessons/67260
# https://tech.kakao.com/2020/07/01/2020-internship-test/
import timeit


def ok():
    for par in range(nn):
        if parents[par] == -1:
            continue
        if find(par, 0) == -100:
            return False
    return True


def solution(n, path, order):
    start = timeit.default_timer()
    global parents, nn
    nn = n
    map = dict()
    parents = [-1 for _ in range(n)]
    visit = [False for _ in range(n)]
    for a, b in order:
        if b == 0:
            return False
        if parents[b] == -1:
            parents[b] = a
        else:
            union(a, b)
    for a, b in path:
        if not map.get(a):
            map[a] = [b]
        else:
            map[a].append(b)
        if not map.get(b):
            map[b] = [a]
        else:
            map[b].append(a)

    if not ok():
        return False

    stack = list()
    stack.append(0)
    failstack = list()
    while stack:
        stop = timeit.default_timer()
        if stop - start > 1.7:
            return False
        pop = stack.pop()
        visit[pop] = True
        for val in map[pop]:
            if visit[val]:  # 방문했다면
                continue
            if parents[val] == -1 or visit[parents[val]]:  # 연결 되있지만 갈 수 없다면
                stack.append(val)  # 연결 되있고 갈 수 있다면
            else:
                failstack.append(val)

        if not stack:   # 스택이 비었다면
            for failpop in failstack:
                if visit[parents[failpop]]:
                    stack.append(failpop)
                    failstack.remove(failpop)

    for vit in visit:
        if not vit:
            return False
    return True


def union(a, b):
    # 자신이 속한 집합 찾기
    aRoot = find(a, 0)
    bRoot = find(b, 0)
    if aRoot == bRoot:
        parents[bRoot] = aRoot
        return True
    return False


def find(a, cnt):
    if cnt >= nn*nn:
        return -100
    if parents[a] < 0:                      # Root 노드에 도달하면 반환
        return a
    parents[a] = find(parents[a], cnt + 1)  # Root 노드가 아니면 부모노드 따라서 루트노드 도달
    return parents[a]


print(solution(9, [[0, 1], [0, 3], [0, 7], [8, 1], [3, 6], [1, 2], [4, 7], [7, 5]], [[8, 5], [6, 7], [4, 1]]))   # true
print(solution(9, [[8, 1], [0, 1], [1, 2], [0, 7], [4, 7], [0, 3], [7, 5], [3, 6]], [[4, 1], [5, 2]]))           # true
print(solution(9, [[0, 1], [0, 3], [0, 7], [8, 1], [3, 6], [1, 2], [4, 7], [7, 5]], [[4, 1], [8, 7], [6, 5]]))   # false
print(solution(9, [[0, 1], [0, 3], [0, 7], [8, 1], [3, 6], [1, 2], [4, 7], [7, 5]], [[8, 5], [6, 7], [4, 1], [5, 3], [3, 8]]))   # true

