def solution(A, B):
    set_A, set_B = set(A.split()), set(B.split())
    return (set_A - set_B) | (set_B - set_A)


print(solution("why airplanes are white", "why airplanes are safe"))
print(solution("big big", "small"))