# 2021-02-02
# https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3
import collections


def solution(participant, completion):
    people_dict = collections.defaultdict(int)
    for parti in participant:
        people_dict[parti] += 1
    for compl in completion:
        people_dict[compl] -= 1
        if not people_dict[compl]:
            del people_dict[compl]

    return list(people_dict.keys())[0]


print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))
