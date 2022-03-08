import sys

input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())

visited = [False] * (n + 1)
distance = [INF] * (n + 1)

start = int(input())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    x, y, c = map(int, input().split())
    graph[x].append((y, c))


def get_smallest_node():
    min_length = INF
    index = 0
    for i in range(1, n + 1):
        if min_length > distance[i] and not visited[i]:
            min_length = distance[i]
            index = i
    return index


def dijkstra(start):
    distance[start] = 0
    visited[start] = True

    for node in graph[start]:
        distance[node[0]] = node[1]

    for _ in range(n - 1):
        next_node = get_smallest_node()
        visited[next_node] = True
        for j in graph[next_node]:
            cost = distance[next_node] + j[1]
            if distance[j[0]] > cost:
                distance[j[0]] = cost


dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])
