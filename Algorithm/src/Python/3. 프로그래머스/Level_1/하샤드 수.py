# 2021-02-11
# https://programmers.co.kr/learn/courses/30/lessons/12947?language=python3
def solution(x):
    return True if x % sum(int(i) for i in str(x)) == 0 else False


print(solution(10))
print(solution(11))
print(solution(12))
print(solution(13))
