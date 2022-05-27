import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

graph = []
result = []
dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]


def bfs(graph, row, col):
    queue = deque()
    queue.append((row, col))
    graph[row][col] = 0
    cnt = 1
    while queue:
        r, c = queue.popleft()
        for d in range(4):
            nr = r + dx[d]
            nc = c + dy[d]
            if 0 <= nr < N and 0 <= nc < N:
                if graph[nr][nc] == 1:
                    cnt += 1
                    queue.append((nr, nc))
                    graph[nr][nc] = 0
    return cnt


for _ in range(N):
    graph.append(list(map(int, input().rstrip())))

for row in range(N):
    for col in range(N):
        if graph[row][col] == 1:
            result.append(bfs(graph, row, col))

result.sort()
print(len(result))
for i in result:
    print(i)
