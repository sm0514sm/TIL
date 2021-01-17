# 배열에서 k개 만큼을 선택했을 때 조합의 수

A = [1, 2, 3, 4, 5, 6]
stack = []


def combination(k, index):
    if k == 0:
        print(stack)
    elif index == len(A):
        return
    else:
        stack.append(A[index])      # stack에 A[index]추가
        combination(k-1, index+1)   # index+1부터 k-1개의 조합 출력
        stack.pop()                 # stack pop
        combination(k, index+1)     # index+1부터 k개의 조합 출력


combination(4, 0)
