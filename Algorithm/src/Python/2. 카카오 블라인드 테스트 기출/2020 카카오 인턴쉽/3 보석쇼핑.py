# https://programmers.co.kr/learn/courses/30/lessons/67258
# https://tech.kakao.com/2020/07/01/2020-internship-test/


def solution(gems):
    answer = []
    lpos = 0
    rpos = 0
    gem_map = {}
    jew_count = len(set(gems))
    min_value = 99999

    while rpos < len(gems):
        if gems[rpos] not in gem_map.keys():
            gem_map[gems[rpos]] = 1
        else:
            gem_map[gems[rpos]] += 1
        if len(gem_map.keys()) == jew_count:
            while True:
                if min_value > rpos - lpos:
                    answer = [lpos + 1, rpos + 1]
                    min_value = rpos - lpos
                    if min_value + 1 == jew_count:
                        return answer
                if gem_map[gems[lpos]] == 1:  # 지금 가능한데 lpos에 있는거 빼면 불가능한 경우
                    break
                gem_map[gems[lpos]] -= 1
                lpos += 1
        rpos += 1
    return answer


print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))  # [3, 7]
print(solution(["AA", "AB", "AC", "AA", "AC"]))  # [1, 3]
print(solution(["XYZ", "XYZ", "XYZ"]))  # [1, 1]
print(solution(["ZZZ", "YYY", "NNNN", "YYY", "BBB"]))  # [1, 5]
