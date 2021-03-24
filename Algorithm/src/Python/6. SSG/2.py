def solution(A, B):
    set_A, set_B = set(A.split()), set(B.split())
    return list((set_A - set_B) | (set_B - set_A))
