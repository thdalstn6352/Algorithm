import sys
INF = int(1e9)
input = sys.stdin.readline

n = int(input())
m = int(input())

distance = [[INF] * (n + 1) for _ in range(n + 1)]
graph = [[] for _ in range(n + 1)]

for i in range(n + 1):
    distance[i][i] = 0

for _ in range(m):
    s, e, v = map(int, input().split())
    distance[s][e] = v

for k in range(n + 1):
    for i in range(n + 1):
        for j in range(n + 1):
            distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])

print(distance)
