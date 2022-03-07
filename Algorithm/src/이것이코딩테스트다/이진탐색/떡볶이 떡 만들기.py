n, m = map(int, input().split())

dduck = sorted(map(int, input().split()))

start = dduck[0]
end = dduck[n - 1]
result = 0


def binarySearch(dduck, start, end):
    if start >= end:
        return None
    total = 0
    mid = (start + end) // 2
    global result
    for d in dduck:
        if d > mid:
            total += d - mid

    if total == m:
        result = mid
    elif total < m:
        binarySearch(dduck, start, mid - 1)
    else:
        result = mid
        binarySearch(dduck, mid + 1, end)


binarySearch(dduck, start, end)
print(result)