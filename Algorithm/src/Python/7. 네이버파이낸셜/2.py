def solution(N):
    enable_print = N % 10
    while N > 0:
        if enable_print == 0 and N % 10 != 0:
            enable_print = 1
        if enable_print >= 1:
            print(N % 10, end="")
        N = N // 10


solution(10011)
print()
solution(11001)
print()
solution(100)
print()
solution(1)
print()
solution(54321)
print()
solution(12345)
print()
solution(1000000000)
print()
solution(376577804958)