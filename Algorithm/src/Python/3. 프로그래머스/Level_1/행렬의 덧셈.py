# 2021-02-11
# https://programmers.co.kr/learn/courses/30/lessons/12950?language=python3
def solution(arr1, arr2):
    row_length = len(arr1)
    col_length = len(arr1[0])
    answer = [[0 for i in range(col_length)] for i in range(row_length)]
    for i in range(row_length):
        for j in range(col_length):
            answer[i][j] = arr1[i][j] + arr2[i][j]
    return answer


print(solution([[1, 2], [2, 3]], [[3, 4], [5, 6]]))
print(solution([[1], [2]], [[3], [4]]))
