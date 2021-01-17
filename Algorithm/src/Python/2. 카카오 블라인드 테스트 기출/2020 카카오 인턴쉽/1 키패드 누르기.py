# https://programmers.co.kr/learn/courses/30/lessons/67256
# https://tech.kakao.com/2020/07/01/2020-internship-test/


def dif(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])


def solution(numbers, hand):
    lpos = [3, 0]
    rpos = [3, 2]
    pad_dict = {
        1:[0,0],
        2:[0,1],
        3:[0,2],
        4:[1,0],
        5:[1,1],
        6:[1,2],
        7:[2,0],
        8:[2,1],
        9:[2,2],
        0:[3,1]
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


print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	,"right"	))  # "LRLLLRLLRRL"
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2],	"left"	))  # "LRLLRRLLLRR"
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0],	"right"))  # "LLRLLRLLRL"
