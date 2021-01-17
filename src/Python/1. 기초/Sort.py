import copy


def selection_sort(arr):
    for i in range(len(arr)):
        min_val = arr[i]
        min_idx = i
        for j in range(i, len(arr)):
            if min_val > arr[j]:
                min_val = arr[j]
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
    return arr


def bubble_sort(arr):
    for i in range(0, len(arr)):
        for j in range(len(arr) - 1, i - 1, -1):
            if arr[j] < arr[j-1]:
                arr[j], arr[j-1] = arr[j-1], arr[j]
    return arr


def insertion_sort(arr):
    for i in range(1, len(arr)):
        tmp = arr[i]
        j = i
        for j in range(i, 0 - 1, -1):
            arr[j] = arr[j-1]
            if tmp > arr[j]:
                break
        arr[j] = tmp
    return arr


def quick_sorting(arr, left, right):
    pLeft = left
    pRight = right
    pivot = (left + right) // 2

    while pLeft < pRight:
        while arr[pLeft] < arr[pivot]:
            pLeft += 1
        while arr[pRight] > arr[pivot]:
            pRight -= 1
        if pLeft <= pRight:
            arr[pLeft], arr[pRight] = arr[pRight], arr[pLeft]
            pLeft += 1
            pRight -= 1
    if left < pRight:
        quick_sorting(arr, left, pRight)
    if right > pLeft:
        quick_sorting(arr, pLeft, right)



def quick_sort(arr):
    quick_sorting(arr, 0, len(arr) - 1)
    return arr

# print(selection_sort([6, 4, 8, 3, 1, 9, 7]))
# print(bubble_sort([6, 4, 8, 3, 1, 9, 7]))
# print(insertion_sort([6, 4, 8, 3, 1, 9, 7]))
#print(quick_sort([6, 4, 8, 3, 1, 9, 7]))


def quicksort2(arr, left, right):
    pleft = left
    pright = right
    pivot = (left + right) // 2

    # partitioning
    while pleft < pright:
        while arr[pleft] < arr[pivot]:
            pleft += 1
        while arr[pright] > arr[pivot]:
            pright -= 1
        if pleft <= pright:
            arr[pleft], arr[pright] = arr[pright], arr[pleft]
            pleft += 1
            pright -= 1

    if left < pright:
        quicksort2(arr, left, pright)
    if right > pleft:
        quicksort2(arr, pleft, right)


arrr = [6, 4, 8, 3, 1, 9, 7]
quicksort2(arrr, 0, 6)
print(arrr)