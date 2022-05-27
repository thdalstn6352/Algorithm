import sys
sys.setrecursionlimit(1000000)

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)


def dfs(start):
    visited[start] = True
    for j in graph[start]:
        if not visited[j]:
            dfs(j)


for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


count = 0

for i in range(1, N + 1):
    if not visited[i]:
        count += 1
        dfs(i)


print(count)