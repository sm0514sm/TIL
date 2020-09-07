
def binary(n):
    count = 1
    while n > 1:
        count = count + 1
        n = int(n/2)
    return count

print(binary(8))