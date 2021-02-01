
possible = False


def solution(n, weaks, dists):
    def do_check(weaks2, start, max_people, peo):
        for weak2 in weaks2:
            if start <= weak2 <= start + dists[peo] or start <= weak2 + n <= start + dists[peo]:
                weaks2.remove(weak2)
        if not weaks2:
            global possible
            possible = True
            return
        if max_people != peo:
            for weak2 in weaks2:
                do_check(weaks2.copy(), weak2, max_people, peo + 1)

    dists.sort(reverse=True)
    people = 0
    global possible
    while people < len(dists):
        people += 1
        for weak in weaks:
            do_check(weaks.copy(), weak, people, 0)
            if possible:
                return people



    return -1


print(solution(12, [1, 5, 6, 10], [1, 2, 3, 4]))  # 2
print(solution(12, [1, 3, 4, 9, 10], [3, 5, 7]))  # 1