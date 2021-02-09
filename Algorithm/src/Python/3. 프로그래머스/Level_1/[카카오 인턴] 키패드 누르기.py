# 2021-02-09
# https://programmers.co.kr/learn/courses/30/lessons/67256?language=python3
def solution(numbers, hand):
    answer = ""
    pad = [[1, 2, 3],
           [4, 5, 6],
           [7, 8, 9],
           ['*', 0, '#']]

    def get_pos(val):
        for i, line in enumerate(pad):
            if val not in line:
                continue
            for j, n in enumerate(line):
                if n == val:
                    return [i, j]

    l_pos = [3, 0]
    r_pos = [3, 2]
    for num in numbers:
        if num in [1, 4, 7]:
            answer += "L"
            l_pos = [[1, 4, 7].index(num), 0]
        elif num in [3, 6, 9]:
            answer += "R"
            r_pos = [[3, 6, 9].index(num), 0]
        else:
            pos = get_pos(num)
            l_dif = abs(l_pos[0] - pos[0]) + abs(l_pos[1] - pos[1])
            r_dif = abs(r_pos[0] - pos[0]) + abs(r_pos[1] - pos[1])
            if (l_dif == r_dif and hand == "right") or l_dif > r_dif:
                r_pos = pos
                answer += "R"
            else:
                l_pos = pos
                answer += "L"
    return answer


print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'))
