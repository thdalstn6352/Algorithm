from collections import deque

n, m = map(int, input().split())

graph = list()
visited = [[False] * m for _ in range(n)]

dir = [[-1, 0], [1, 0], [0, 1], [0, -1]]

for _ in range(n):
    graph.append(list(map(int, input())))


def bfs(x, y, cnt):
    queue = deque()
    visited[x][y] = True
    queue.append((x, y, cnt))
    while queue:
        r, c, count = queue.popleft()
        if r == n - 1 and c == m - 1:
            return count
        for d in range(4):
            nr = r + dir[d][0]
            nc = c + dir[d][1]
            if 0 <= nr < n and 0 <= nc < m and graph[nr][nc] == 1 and not visited[nr][nc]:
                visited[nr][nc] = True
                queue.append((nr, nc, count + 1))


total = bfs(0, 0, 1)
print(total)