import sys
INF = int(1e9)

input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(n + 1):
    graph[i][i] = 0

for _ in range(m):
    s, e, v = map(int, input().split())
    graph[s][e] = v


for k in range(n + 1):
    for i in range(n + 1):
        for j in range(n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

print(graph)

