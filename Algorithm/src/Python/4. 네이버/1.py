def solution(n, p, c):
    answer = 0
    per_price = 100

    for i in range(n):
        if p[i] >= c[i]:
            answer += c[i] * per_price
            per_price = 100
            if i != n - 1:
                p[i + 1] += p[i] - c[i]
        else:
            if per_price == 25:
                n = i + 1
                break
            else:
                per_price /= 2
            if i != n - 1:
                p[i + 1] += p[i]


    answer /= n

    return str("%.2f" % round(answer, 2))



print(solution(6, [5, 4, 7, 2, 0, 6], [4, 6, 4, 9, 2, 3]))  # 275.00
print(solution(7, [6, 2, 1, 0, 2, 4, 3], [3, 6, 6, 2, 3, 7, 6]))  # 100.00


