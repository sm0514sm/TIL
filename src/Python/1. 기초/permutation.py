

def permu(arr, index, R):
    if index == R:
        print(arr[:R])
        global num
        num += 1
        return
    for i in range(index, len(arr)):
        arr[i], arr[index] = arr[index], arr[i]
        permu(arr, index + 1, R)
        arr[i], arr[index] = arr[index], arr[i]


def combi(arr, before, index,  R):
    if index == R:
        print(arr[:R])
        return
    for i in range(before, len(arr)):
        arr[index] = i
        combi(arr, i + 1, index + 1, R)



num = 0
# permu([1, 2, 3, 4], 0, 3)
combi([0, 0, 0, 0, 0], 0, 0, 3)
print(num)