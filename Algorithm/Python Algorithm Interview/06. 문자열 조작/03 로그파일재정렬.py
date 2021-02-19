# 2021-01-25
# 리트코드 937. Reorder Log Files

# Q: 로그를 재정렬 하라
# 1. 가장 앞부분은 식별자
# 2. 문자로 구성된 로그가 숫자 로그보다 앞에 온다
# 3. 식별자는 순서에 영향 안끼치지만, 문자가 동일할 경우 식별자 순으로
# 4. 숫자 로그는 입력 순서대로

def my_solution(logs: list) -> list:
    letters, digits = [], []
    for log in logs:
        if log.split()[1].isdigit():
            digits.append(log)
        else:
            letters.append(log)

    # key=lambda를 이용해서 튜플에 나오는 순서대로 정렬 가능
    letters.sort(key=lambda letter: (letter.split()[1:], letter.split()[0]))

    return letters + digits


print(my_solution(["dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"]))
