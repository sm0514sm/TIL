# 2021-02-02
# https://programmers.co.kr/learn/courses/30/lessons/42840?language=python3

def solution(answers):
    supo1 = [1, 2, 3, 4, 5]
    supo2 = [2, 1, 2, 3, 2, 4, 2, 5]
    supo3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    answer_list = [0, 0, 0]
    for i, ans in enumerate(answers):
        answer_list[0] += 1 if ans == supo1[i % len(supo1)] else 0
        answer_list[1] += 1 if ans == supo2[i % len(supo2)] else 0
        answer_list[2] += 1 if ans == supo3[i % len(supo3)] else 0

    max_ans = 0
    max_list = [1, 2, 3]
    for i, ans in enumerate(answer_list):
        if ans > max_ans:
            max_ans = ans
            max_list = [i + 1]
        elif ans == max_ans:
            max_list.append(i + 1)
    return max_list


print(solution([1, 2, 3, 4, 5]))
print(solution([1, 3, 2, 4, 2]))
