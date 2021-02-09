# 아래 옛날
def dif(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])


def solution(numbers, hand):
    lpos = [3, 0]
    rpos = [3, 2]
    pad_dict = {
        1: [0, 0],
        2: [0, 1],
        3: [0, 2],
        4: [1, 0],
        5: [1, 1],
        6: [1, 2],
        7: [2, 0],
        8: [2, 1],
        9: [2, 2],
        0: [3, 1]
    }
    answer = ''
    for number in numbers:
        if number in [1, 4, 7]:
            lpos = pad_dict[number]
            answer += 'L'
        elif number in [3, 6, 9]:
            rpos = pad_dict[number]
            answer += 'R'
        else:
            ldif = dif(lpos, pad_dict[number])
            rdif = dif(rpos, pad_dict[number])
            if ldif > rdif:
                answer += 'R'
                rpos = pad_dict[number]
            elif ldif < rdif:
                answer += 'L'
                lpos = pad_dict[number]
            else:
                if hand == 'right':
                    answer += 'R'
                    rpos = pad_dict[number]
                else:
                    answer += 'L'
                    lpos = pad_dict[number]
    print(answer)
    return answer
