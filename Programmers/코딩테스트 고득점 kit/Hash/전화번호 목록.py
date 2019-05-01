# 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
# 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false 를
# 그렇지 않으면 true 를 return 하도록 solution 함수를 작성해주세요.


def solution(phone_book):
    answer = True
    phone_book.sort()
    for i, phone in enumerate(phone_book):
        if i < len(phone_book) -2:
            if phone in phone_book[i+1]:
                answer = False
                break
    return answer


print(solution(["119", "97674223", "1195524421"]))  # false
print(solution(["123", "456", "789"]))  # true
print(solution(["12", "123", "1235", "567", "88"]))     # false
