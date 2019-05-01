# 마라톤에 참여한 선수들의 이름이 담긴 배열 participant 와
# 완주한 선수들의 이름이 담긴 배열 completion 이 주어질 때,
# 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.


def solution(participant, completion):
    answer = ''
    count = {}
    for person in participant:
        if person in count.keys():
            count[person] += 1
        else:
            count[person] = 1
    for person in completion:
        count[person] -= 1

    for key in count.keys():
        if count[key] != 0:
            answer = key
            break

    return answer


print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))  # leo
print(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]))  # vinko
print(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]))     # mislav
