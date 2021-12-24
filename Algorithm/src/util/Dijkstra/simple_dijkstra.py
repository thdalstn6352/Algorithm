import sys

input = sys.stdin.readline()

INF = int(1e9)

# 노드 개수, 간선 개수
n, m = map(int, input().split())

# 시작 노드
start = int(input())

# 노드와 간선 정보
graph = [[] for i in range(n + 1)]

# 방문 체크
visited = [False] * (n + 1)

# 최단거리 리스트
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def get_smallest_node():
    min_value = INF
    index = 0
    for i in range(1, n + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index


def dijkstra(start):
    distance[start] = 0
    visited[start] = True

    for j in graph[start]:
        distance[j[0]] = j[1]

    for i in range(n - 1):
        now = get_smallest_node()
        visited[now] = True

        for j in graph[now]:
            cost = distance[now] + j[1]
            if cost < distance[j[0]]:
                distance[j[0]] = cost


dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])