import heapq

def solution(operations):
    heap = []
    for oper in operations:
        op, num = oper.split()
        num = int(num)
        if op == 'I':
            heapq.heappush(heap, num)
        elif len(heap) != 0:
            if num == 1:
                print(heapq.nlargest(1, heap)[0])
                heap.remove(heapq.nlargest(1, heap)[0])
            else:
                print(heapq.nsmallest(1, heap)[0])
                heap.remove(heapq.nsmallest(1, heap)[0])
    if heap:
        return [heapq.nlargest(1, heap)[0], heapq.nsmallest(1, heap)[0]]
    else:
        return [0, 0]


print(solution(["I 16", "D 1"]))  # [0,0]
print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))  # [0, 0]
