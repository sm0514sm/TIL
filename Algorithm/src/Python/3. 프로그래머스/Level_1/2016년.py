# 2021-02-03
# https://programmers.co.kr/learn/courses/30/lessons/12901?language=python3

def solution(a, b):
    month_days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day_list = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    result_day = sum(month_days[:a]) + b
    return day_list[(result_day - 1) % 7]


print(solution(5, 24))