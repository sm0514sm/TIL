def solution(k):
    cnts = [(2, 1), (3, 7), (4, 4), (5, 2), (5, 3), (5, 5), (6, 0), (6, 6), (6, 9), (7, 8)]  # (v, k)  k번째 수 만드는데 필요한 성냥개수 v

    def dfs(txt, target):
        if len(txt) >= 2 and txt[0] == '0':
            return 0
        if target == 0:

            # print(txt, end=", ")
            return 1
        elif target == 1:
            return 0
        ans = 0
        for cnt in cnts:
            if cnt[0] <= target:
                ans += dfs(txt + str(cnt[1]), target - cnt[0])
        return ans


    return dfs('', k)


for i in range(1, 50):
    print(i, solution(i))