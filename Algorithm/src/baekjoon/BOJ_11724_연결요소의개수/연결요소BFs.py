from collections import deque

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)


def bfs(start):
    queue = deque([start])
    visited[start] = True
    while queue:
        node = queue.popleft()
        for value in graph[node]:
            if not visited[value]:
                visited[value] = True
                queue.append(value)


for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


count = 0

for i in range(1, N + 1):
    if not visited[i]:
        count += 1
        bfs(i)


print(count)