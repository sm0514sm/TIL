def solution(k):
    dp = [[0] * 50 for _ in range(25)]
    dp[1][2] = 1
    dp[1][3] = 1
    dp[1][4] = 1
    dp[1][5] = 3
    dp[1][6] = 3
    dp[1][7] = 1
    dp[2][4] = 1
    dp[2][5] = 2
    dp[2][6] = 3
    dp[2][7] = 8
    dp[3][6] = 1
    dp[3][7] = 3

    for j in range(8, k + 1):
        for n in range(1, k/2):



    ans = 0
    for d in dp:
        ans += d[k]
    return ans


for i in range(1, 12):
    print(solution(i), "개  ", i, "개로")

# 1111 14