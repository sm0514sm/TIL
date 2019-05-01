# 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
# 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
# 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
# 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
# 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

import operator


def solution(genres, plays):
    playdic = {}
    genresdic = {}
    for i, genre in enumerate(genres):
        if genre in playdic.keys():
            playdic[genre] += plays[i]
            genresdic[genre][str(i)]= plays[i]
        else:
            playdic[genre] = plays[i]
            genresdic[genre] = {str(i): plays[i]}
    playdic = sorted(playdic.items(), key=operator.itemgetter(1), reverse=True)
    for key, value in genresdic.items():
        genresdic[key] = sorted(value.items(), key=operator.itemgetter(1), reverse=True)
    answer = []
    for genre in playdic:
        count = 0
        while True:
            answer.append(int(genresdic[genre[0]][count][0]))
            count += 1
            if count == len(genresdic[genre[0]]) or count == 2:
                break

    return answer


print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))    # 4, 1, 3, 0
