import sys
n = int(input())
data = sorted(sys.stdin.readline().rstrip().split())

m = int(input())
target = sys.stdin.readline().rstrip().split()


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


for i in target:
    result = binary_search(data, i, 0, n - 1)
    if result == None:
        print("no", end=" ")
    else:
        print("yes", end=" ")


