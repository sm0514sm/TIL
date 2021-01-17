import heapq

def time_to_int(date, time):
    monthday = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    month, day = date.split("/")
    month = int(month)
    day = int(day)-1
    for i in range(month):
        day += monthday[i]

    h, m, s = time.split(":")
    h = int(h)
    m = int(m)
    s = int(s)
    return day * 24 * 3600 + h * 3600 + m * 60 + s


def solution(n, customers):
    count = [(0, i+1) for i in range(n)]  # time과 키오스크 번호
    num = [0 for i in range(n)]  # 횟수
    for cust in customers:
        date, time, minute = cust.split()

        minimun = heapq.heappop(count)
        temp = time_to_int(date, time)
        if minimun[0] > temp:
            heapq.heappush(count, (minimun[0] + int(minute) * 60, minimun[1]))
        else:
            heapq.heappush(count, (temp + int(minute) * 60, minimun[1]))
        num[minimun[1]-1] += 1
        print(minimun[1])
    return max(num)




# print(solution(3, ["10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"]))
print(solution(3, ["01/01 00:00:00 01", "01/01 00:01:00 04", "01/01 00:02:00 03", "01/01 00:03:00 02", "01/01 00:06:00 01"]))

