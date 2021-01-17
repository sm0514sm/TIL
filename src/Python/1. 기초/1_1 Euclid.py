# euclid 알고리즘을 통해 GCD를 구한다.


def euclid(m, n):
    while not n == 0:
        r = m % n
        m = n
        n = r
    return m


print(euclid(60, 24))
print(euclid(31415, 14142))