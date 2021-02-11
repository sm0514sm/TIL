# 2021-02-11
# https://programmers.co.kr/learn/courses/30/lessons/17682?language=python3
def solution(dartResult):
    answer = []
    bonus_dict = {'S': 1, 'D': 2, 'T': 3}
    i = 0
    while i < len(dartResult):
        score = int(dartResult[i:i + 2]) if i + 1 < len(dartResult) and dartResult[i + 1].isdigit() else int(
            dartResult[i])
        i += len(str(score))
        bonus = dartResult[i]
        i += 1
        option = dartResult[i] if i < len(dartResult) and dartResult[i] in ['*', '#'] else None
        i += 1 if option else 0
        answer.append((score ** bonus_dict[bonus]))
        if option == '*':
            answer[-1] *= 2
            if len(answer) != 1:
                answer[-2] *= 2
        elif option == '#':
            answer[-1] *= -1
    return sum(answer)


print(solution("1S2D*3T"))
