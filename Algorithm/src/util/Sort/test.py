array = [7, 6, 9, 0, 1, 3, 5, 2, 4, 8]


def selection_sort(arr):
    for i in range(len(arr)):
        min_index = i
        for j in range(i+1, len(arr)):
            if arr[min_index] > arr[j]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]
    return arr


def insertion_sort(array):
    for i in range(1, len(array)):
        for j in range(i, 0, -1):
            if array[j] < array[j-1]:
                array[j], array[j-1] = array[j-1], array[j]
            else:
                break
    return array


def quick_sort1(array, start, end):
    print(array)
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end

    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right >= start and array[right] >= array[pivot]:
            right -= 1

        print(left, right)
        print(array[left], array[right])
        if left > right:
            array[pivot], array[right] = array[right], array[pivot]
        else:
            array[left], array[right] = array[right], array[left]
        print(array)
        print(left, right)
    return array


def quick_sort2(array):
    if len(array) <= 1:
        return array
    pivot = array[0]
    left = array[1:]
    right = array[1:]

    left_arr = [x for x in left if x <= pivot]
    right_arr = [x for x in right if x > pivot]

    return quick_sort2(left_arr) + [pivot] + quick_sort2(right_arr)




print(quick_sort2(list(array)))
# print(selection_sort(list(array)))
# print(insertion_sort(list(array)))
# print(quick_sort1(list(array), 0, len(array) - 1))
