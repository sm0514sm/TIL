def solution(begin, target, words):
    if target not in words:
        return 0
    answer = 0
    wordlen = len(begin)
    words.insert(0, begin)
    target = words.index(target)
    # ways 설정
    ways = [[0] * len(words) for i in range(len(words))]
    for i, word1 in enumerate(words):
        for j, word2 in enumerate(words):
            if word1 == word2:
                continue
            dif_cnt = 0
            for k in range(wordlen):
                if word1[k] != word2[k]:
                    dif_cnt += 1
                if dif_cnt >= 2:
                    break
            if dif_cnt < 2:
                ways[i][j] = 1
                ways[j][i] = 1
    # BFS 탐색
    queue = [0]
    visited = [False for i in range(len(words))]
    dept = 0
    while queue:
        qsize = len(queue)
        dept += 1
        for _ in range(qsize):
            pop = queue.pop(0)
            visited[pop] = True
            for i in range(len(words)):
                if visited[i] or ways[pop][i] == 0:
                    continue
                if i == target:
                    return dept
                queue.append(i)
    return answer


print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))  # 4
print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]))  # 0
