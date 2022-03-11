import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    q = []

    length = len(food_times)
    sum = 0
    previous = 0

    for i in range(length):
        heapq.heappush(q, (food_times[i], i + 1))

    while sum + ((q[0][0] - previous) * length) <= k:
        now = heapq.heappop(q)[0]
        sum += (now - previous) * length
        length -= 1
        previous = now

    result = sorted(q, key=lambda x: x[1])
    return result[(k - sum) % length][1]
