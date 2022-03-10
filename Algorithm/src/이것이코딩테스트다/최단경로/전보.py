import heapq
import sys

input = sys.stdin.readline
n, m, start = map(int, input().split())
INF = int(1e9)

graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    x, y, c = map(int, input().split())
    graph[x].append((y, c))


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue
        for node in graph[now]:
            cost = dist + node[1]
            if cost < distance[node[0]]:
                distance[node[0]] = cost
                heapq.heappush(q, (cost, node[0]))

dijkstra(start)

count = 0
time = 0
for i in range(1, n + 1):
    if distance[i] != INF and distance[i] != 0:
        count += 1
        time = max(time, distance[i])

print(count, time)
