# 2021-02-11
# https://programmers.co.kr/learn/courses/30/lessons/17681?language=python3
def solution(n, arr1, arr2):
    answer = []
    real_map = [i | j for i, j in zip(arr1, arr2)]
    for row in real_map:
        answer.append(bin(row)[2:].replace("1", "#").replace("0", " ").rjust(n, ' '))
    return answer


print(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))
print(solution(6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]))
