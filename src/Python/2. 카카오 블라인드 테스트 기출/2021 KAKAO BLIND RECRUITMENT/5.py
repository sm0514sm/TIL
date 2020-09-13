def time_to_int(time):
    h = int(time[0:2])
    m = int(time[3:5])
    s = int(time[6:8])
    return h * 3600 + m * 60 + s


def int_to_time(time):
    h = time // 3600
    m = (time % 3600) // 60
    s = time % 60
    return '%02d:%02d:%02d' % (h, m, s)


def set1(a, b):
    for i in range(a, b):
        time_list[i] += 1


def solution(play_time, adv_time, logs):
    global time_list
    play_time = time_to_int(play_time)
    adv_time = time_to_int(adv_time)
    time_list = [0 for _ in range(play_time)]
    for log in logs:
        a, b = log.split("-")
        a = time_to_int(a)
        b = time_to_int(b)
        set1(a, b)

    maxv = 0
    maxs = 0
    tmp_sum = 0

    for i in range(play_time - 1, play_time - adv_time - 1, -1):
        if i < 0:
            break
        tmp_sum += time_list[i]
    if maxv < tmp_sum:
        maxv = tmp_sum
        maxs = play_time-adv_time-1

    for i in range(play_time - 1, adv_time - 1, -1):
        tmp_sum -= time_list[i]
        tmp_sum += time_list[i-adv_time]
        if maxv <= tmp_sum:
            maxv = tmp_sum
            maxs = i-adv_time

    return int_to_time(0 if maxs < 0 else maxs)


time_list = []
print(solution("02:03:55", "00:14:15", ["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]))  # "01:30:59"
print(solution("99:59:59", "25:00:00", ["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]))  # "01:00:00"
print(solution("50:00:00", "50:00:00", ["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]))  # "00:00:00"