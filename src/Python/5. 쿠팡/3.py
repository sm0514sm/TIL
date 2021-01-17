from collections import defaultdict


def solution(k, scores):
    delset = set()
    dif_dict = defaultdict(list)
    for i in range(len(scores) - 1):
        dif_dict[scores[i] - scores[i+1]].append({i, i+1})

    for key, vals in dif_dict.items():
        if len(vals) >= k:
            for val in vals:
                delset = delset.union(val)
    print(delset)

    return len(scores) - len(delset)

print(solution(3, [24,22,20,10,5,3,2,1]))