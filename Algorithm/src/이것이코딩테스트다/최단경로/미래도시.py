INF = int(1e9)

n, m = map(int, input().split())
graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    graph[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

x, k = map(int, input().split())

for j in range(1, n + 1):
    for s in range(1, n + 1):
        for d in range(1, n + 1):
            graph[s][d] = min(graph[s][d], graph[s][j] + graph[j][d])

result = graph[1][k] + graph[k][x]

print(result if result < INF else -1)





