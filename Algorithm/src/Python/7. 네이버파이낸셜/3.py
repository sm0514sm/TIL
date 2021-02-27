def solution(A):
    A.sort(reverse=True)

    for i in A:
        if 0 <= i < 10:
            return i


print(solution([-6, -91, 1011, -100, 84, -22, 0, 473]))