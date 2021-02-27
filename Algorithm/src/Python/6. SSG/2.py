# 두 개의 문장 A와 B가 주어집니다. 한 문장은 공백으로 구분 된 단어의 문자열로 구성되어 있습니다. 각 단어는 소문자로만 구성됩니다.
# 문장 중 하나에 정확하게 한번만 나타나고 다른 문장에는 나타나지 않은 단어를 찾아내면 됩니다.
# 단어의 순서는 보장되지 않아도 됩니다.
def solution(A, B):
    set_A, set_B = set(A.split()), set(B.split())
    return (set_A - set_B) | (set_B - set_A)


print(solution("why airplanes are white", "why airplanes are safe"))
print(solution("big big", "small"))