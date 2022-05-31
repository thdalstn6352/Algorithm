import sys
import heapq
INF = int(1e9)

input = sys.stdin.readline

n, m = map(int, input().split())
start = int(input())

distance = [INF] * (n + 1)
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e, v = map(int, input().split())
    graph[s].append((e, v))


def dijkstra(node):
    heap = []
    heapq.heappush(heap, (0, node))
    distance[node] = 0

    while heap:
        value, now = heapq.heappop(heap)

        if distance[now] < value:
            continue

        for data in graph[now]:
            cost = value + data[1]

            if cost < distance[data[0]]:
                distance[data[0]] = cost
                heapq.heappush(heap, (cost, data[0]))


dijkstra(start)
print(distance)
