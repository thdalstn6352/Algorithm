import sys
import heapq
input = sys.stdin.readline

n = int(input())
arr = list()
data = 0
for _ in range(n):
    heapq.heappush(arr, int(input()))

while len(arr) != 1:
    x, y = heapq.heappop(arr), heapq.heappop(arr)
    data += (x + y)
    heapq.heappush(arr, x + y)

print(data)