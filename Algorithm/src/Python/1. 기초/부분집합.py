def subset_while():
    loopcnt = 1 << N
    for i in range(loopcnt):
        for j in range(N):
            if (i & 1 << j) > 0:
                print(j, end=" ")
        print()


N = 5
# print(1 << N)
# subset_while()


def subset():
    loopcnt = 1 << N
    for i in range(loopcnt):
        for j in range(N):
            if (i & 1 << j) > 0:
                print(j, end=" ")
        print()

# subset()
