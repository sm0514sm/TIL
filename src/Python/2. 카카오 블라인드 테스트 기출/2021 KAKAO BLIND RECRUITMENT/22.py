from itertools import combinations


def solution(orders, course):
    max_order_len = 0
    answer = []
    dish_dict = {}
    for order in orders:
        if max_order_len < len(order):
            max_order_len = len(order)
        for orde in order:
            if not dish_dict.get(orde):
                dish_dict[orde] = 1
            else:
                dish_dict[orde] += 1
    for k, v in list(dish_dict.items()):
        if v < 2:
            del dish_dict[k]

    for num in course:
        if num > max_order_len:
            break
        tmp = []
        for course_possi in combinations(dish_dict.keys(), num):
            cnt = 0
            for order in orders:
                if len(order) < num:
                    continue
                isok = True
                for cour in course_possi:
                    if cour not in order:
                        isok = False
                        break
                if not isok:
                    continue
                else:
                    cnt += 1
            if cnt >= 2:
                tmp.append((course_possi, cnt))
        maxv = 0
        for tm in tmp:
            if maxv < tm[1]:
                maxv = tm[1]
        for tm in tmp:
            if maxv == tm[1]:
                answer.append(''.join(sorted(tm[0])))

    return sorted(answer)


print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))  # ["AC", "ACDE", "BCFG", "CDE"]
print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2,3,5]))  # ["ACD", "AD", "ADE", "CD", "XYZ"]
print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))  # ["WX", "XY"]
