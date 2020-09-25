import copy


def solution(tickets):
    answer = []

    def go_travel(tick_dict, start, ans):
        if not tick_dict:
            answer.append(ans)
        if not tick_dict.get(start):
            return
        for tolist in tick_dict[start]:
            for to in [tolist]:
                temp_dict = copy.deepcopy(tick_dict)
                temp_dict[start].remove(to)
                if not temp_dict[start]:
                    del temp_dict[start]
                go_travel(temp_dict, to, ans[:] + [to])


    tickets_dict = {}
    for a, b in tickets:
        if tickets_dict.get(a):
            tickets_dict[a].append(b)
        else:
            tickets_dict[a] = [b]
    # print(tickets_dict)
    go_travel(tickets_dict, 'ICN', ['ICN'])
    answer.sort()
    return answer[0]


print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))  # [ICN, JFK, HND, IAD]
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]))  # [ICN, ATL, ICN, SFO, ATL, SFO]
