
def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if array[mid] == target:
        return mid + 1
    elif array[mid] < target:
        return binary_search(array, target, mid + 1, end)
    else:
        return binary_search(array, target, start, mid - 1)


n, target = map(int, input().split())
data = list(map(int, input().split()))

print(binary_search(data, target, 0, n - 1))

