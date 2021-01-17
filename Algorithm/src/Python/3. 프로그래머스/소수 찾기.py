import itertools, math


def issosu(param):
    if param < 2:
        return False
    for div in range(int(math.sqrt(param)), 1, -1):
        if param % div == 0:
            return False
    return True



def solution(numbers):
    answer = 0
    for i in range(1, len(numbers) + 1):
        per_list = list(itertools.permutations(numbers, i))
        j = 0
        while j < len(per_list):
            perm = per_list[j]
            per_list.remove(perm)
            if perm[0] == '0' or perm in per_list:
                continue
            else:
                per_list.insert(j, perm)
                j += 1
            if issosu(int(''.join(perm))):
                answer += 1
    return answer



print(solution("17"))  # 3
print(solution("011"))  # 2
