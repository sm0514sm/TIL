# https://www.welcomekakao.com/learn/courses/30/lessons/42888?language=python3
# https://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/

def solution(record):
    answer = []
    order = []
    word_dict = {}
    do_text = ["님이 들어왔습니다.", "님이 나갔습니다."]
    for rec in record:
        tmp = rec.split()
        if len(tmp) == 3:
            do, uid, nick = tmp
            word_dict[uid] = nick
            if do == "Enter":
                order.append((0, uid))
        else:
            do, uid = tmp
            order.append((1, uid))
    for orde in order:
        do, uid = orde
        answer.append(word_dict.get(uid) + do_text[do])
    print(answer)
    return answer


print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]))
# ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
