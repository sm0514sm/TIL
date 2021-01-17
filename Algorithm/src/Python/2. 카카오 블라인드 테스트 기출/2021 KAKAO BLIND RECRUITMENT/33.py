def dictadd(diction, data, i, len_users):

    if not diction.get(data):
        diction[data] = set()
        diction[data].add(i)
    else:
        diction[data].add(i)


def solution(info, query):
    answer = []
    users = []  # 0언어 1직군 2경력 3소울푸드 4점수
    lang_dict = {}
    end_dict = {}
    nior_dict = {}
    food_dict = {}
    for i, inf in enumerate(info):
        data = inf.split()
        users.append(data)
        dictadd(lang_dict, data[0], i, len(users))
        dictadd(end_dict, data[1], i, len(users))
        dictadd(nior_dict, data[2], i, len(users))
        dictadd(food_dict, data[3], i, len(users))

    for que in query:
        lang, end, nior, tmp = que.split(" and ")
        food, score = tmp.split()
        possible_list = set()
        for i in range(len(users)):
            possible_list.add(i)
        if lang_dict.get(lang):
            possible_list &= lang_dict[lang]
        if end_dict.get(end):
            possible_list &= end_dict[end]
        if nior_dict.get(nior):
            possible_list &= nior_dict[nior]
        if food_dict.get(food):
            possible_list &= food_dict[food]

        cnt = 0
        for person in possible_list:
            if int(users[person][4]) >= int(score):
                cnt += 1
        answer.append(cnt)

    return answer


print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"], ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))  # [1,1,1,1,2,4]
print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"], ["- and backend and senior and - 150"]))  # [1]
print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"], ["- and - and - and - 150"]))  # [4]
