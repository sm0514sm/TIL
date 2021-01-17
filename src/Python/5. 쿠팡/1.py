def convert(n, base):
    T = "0123456789"
    value = n // base
    r = n % base
    if value == 0:
        return T[r]
    else:
        return convert(value, base) + T[r]


def solution(N):
    answer = []
    index = maximun = 0
    for i in range(2, 10):
        num = convert(N, i)
        total = eval('*'.join(str(num)))
        if total >= maximun:
            maximun = total
            index = i
    answer.append(index)
    answer.append(maximun)
    return answer

if __name__ == '__main__':
    N = 14
    print(solution(N))