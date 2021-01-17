# 그레이 코드를 만든다.


# list의 각 배열에 문자 x를 맨앞에 추가한다.
def addbit(list, x):
    for i in range(0, len(list)):
        list[i] = x + list[i]

    return list


# n비트의 그레이코드를 만든다.
def BRGC(n):
    if n == 1:
        list = ["0", "1"]
        return list
    else:
        list1 = BRGC(n-1)           # list1은 n-1비트의 리스트
        list2 = list1.copy()        # list2는 list1의 역방향
        list2.reverse()
        list1 = addbit(list1, "0")  # list1의 각 요소의 맨 앞에 0을 추가
        list2 = addbit(list2, "1")  # list2의 각 요소의 맨 앞에 1을 추가
        list = list1 + list2        # list1에 list2 리스트를 더함
    return list


print(BRGC(3))

