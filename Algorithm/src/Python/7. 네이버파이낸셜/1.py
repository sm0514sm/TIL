def solution(P, S):
    total_people = sum(P)
    car_cnt = 0
    for s in sorted(S, reverse=True):
        car_cnt += 1
        total_people -= s
        if total_people <= 0:
            return car_cnt


print(solution([1, 4, 1], [1, 5, 1]))
print(solution([4, 4, 2, 4], [5, 5, 2, 5]))
print(solution([2, 3, 4, 2], [2, 5, 7, 2]))
