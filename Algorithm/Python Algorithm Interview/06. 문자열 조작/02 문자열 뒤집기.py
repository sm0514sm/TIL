# 2021-01-21
# 리트코드 344. Reverse String

# Q: 문자열을 뒤집는 함수 작성. 입력값은 문자 배열, 리턴 없이 리스트 내부를 직접 조작
def my_solution(str_arr: list) -> None:
    r, l = 0, len(str_arr) - 1
    while r < l:
        str_arr[r], str_arr[l] = str_arr[l], str_arr[r]
        r += 1
        l -= 1


def solution1(str_arr: list) -> None:
    str_arr[:] = str_arr[::-1]  # [:] 이 필요


def solution2(str_arr: list) -> None:
    str_arr.reverse()


input_arr: list = ["h", "e", "l", "l", "o"]
my_solution(input_arr)
print(input_arr)
input_arr: list = ["H", "a", "n", "n", "a", "h"]
my_solution(input_arr)
print(input_arr)

input_arr: list = ["h", "e", "l", "l", "o"]
solution1(input_arr)
print(input_arr)
input_arr: list = ["H", "a", "n", "n", "a", "h"]
solution1(input_arr)
print(input_arr)

input_arr: list = ["h", "e", "l", "l", "o"]
solution2(input_arr)
print(input_arr)
input_arr: list = ["H", "a", "n", "n", "a", "h"]
solution2(input_arr)
print(input_arr)
