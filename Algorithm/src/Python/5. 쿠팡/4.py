from collections import defaultdict


def solution(depar, hub, dest, roads):
    way_dict = defaultdict(set)
    for road in roads:
        way_dict[road[0]].add(road[1])

    stack = [depar]
    cnt1 = 0
    while stack:
        pop = stack.pop()
        if pop == hub:
            cnt1 += 1
            continue
        for way in way_dict[pop]:  # pop 이 갈 수 있는 도시들
            if way == dest:
                continue
            stack.append(way)
    print(cnt1)
    if cnt1 == 0:
        return 0
    cnt1 %= 10007

    stack = [hub]
    cnt2 = 0
    while stack:
        pop = stack.pop()
        if pop == dest:
            cnt2 += 1
            continue
        for way in way_dict[pop]:  # pop 이 갈 수 있는 도시들
            stack.append(way)
    print(cnt2)
    cnt2 %= 10007

    return (cnt1 * cnt2) % 10007





arg = []

for i in range(1, 101):  # 1부터 100까지
    arg.append([0, i])

for i in range(1, 101):
    for j in range(101, 201):
        arg.append([i, j])

for i in range(101, 201):
    for j in range(201, 301):
        arg.append([i, j])

for i in range(201, 301):
    for j in range(301, 401):
        arg.append([i, j])

for i in range(301, 401):
    arg.append([i, 500])

print(len(arg))
print(solution(0, 250, 500, arg))



# print(solution("SEOUL", "DAEGU", "YEOSU", [["ULSAN","BUSAN"],["DAEJEON","ULSAN"],["DAEJEON","GWANGJU"],["SEOUL","DAEJEON"],["SEOUL","ULSAN"],["DAEJEON","DAEGU"],["GWANGJU","BUSAN"],["DAEGU","GWANGJU"],["DAEGU","BUSAN"],["ULSAN","DAEGU"],["GWANGJU","YEOSU"],["BUSAN","YEOSU"]]))
# print(solution("ULSAN", "SEOUL", "BUSAN", [["SEOUL","DAEJEON"],["ULSAN","BUSAN"],["DAEJEON","ULSAN"],["DAEJEON","GWANGJU"],["SEOUL","ULSAN"],["DAEJEON","BUSAN"],["GWANGJU","BUSAN"]]))