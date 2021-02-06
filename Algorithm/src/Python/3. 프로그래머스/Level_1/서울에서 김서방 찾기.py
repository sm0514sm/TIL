# 2021-02-06
# https://programmers.co.kr/learn/courses/30/lessons/12919?language=python3

def solution(seoul):
    index = 0
    for i, seo in enumerate(seoul):
        if seo == "Kim":
            index = i
            break
    return "김서방은 %d에 있다" % index


# list.index 를 활용하자!
def solution2(seoul):
    return "김서방은 %d에 있다" % seoul.index("Kim")


print(solution2(["qwf", "Kim"]))