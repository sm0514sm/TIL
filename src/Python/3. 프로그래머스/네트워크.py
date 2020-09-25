# https://programmers.co.kr/learn/courses/30/lessons/43162?language=python3

def solution(n, computers):
    answer = 0
    computers_set = set([i for i in range(n)])
    while computers_set:
        queue = [list(computers_set)[0]]
        visit_set = set()
        while queue:
            pop = queue.pop(0)
            visit_set.add(pop)
            for index, num in enumerate(computers[pop]):
                if index == pop:
                    continue
                if num == 1 and index not in visit_set:
                    queue.append(index)
        computers_set -= visit_set
        answer += 1
    return answer



print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))  # 2
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))  # 1
