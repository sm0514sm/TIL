from collections import defaultdict
import copy
def solution(depar, hub, dest, roads):
    answer = 0
    map = defaultdict(set)
    for road in roads:
        map[road[0]].add(road[1])
    que = []
    visit = [depar]
    que.append((depar, visit))
    while que:
        temp = que.pop()
        now = temp[0]
        visit = temp[1]
        if now == dest:
            if hub in visit:
                answer+=1
                answer=answer%10007
            continue
        for city in map[now]:
            if city not in visit:
                road = copy.deepcopy(visit)
                road.append(city)
                que.append((city, road))
    return answer%10007



arg = []

for i in range(1, 101):
    arg.append([0, i])

for i in range(1, 101):
    for j in range(101, 201):
        arg.append([i, j])

for i in range(100, 201):
    for j in range(201, 301):
        arg.append([i, j])

for i in range(301, 401):
    arg.append([i, 500])

# print(arg)
print(solution(0, 250, 500, arg))