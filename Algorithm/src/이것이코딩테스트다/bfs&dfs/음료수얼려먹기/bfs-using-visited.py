from collections import deque

data = list()
n = 4
m = 5
visited = [[False] * m for _ in range(n)]
cnt = 0

for _ in range(n):
    data.append(list(map(int, input())))

dir = [[-1, 0], [1, 0], [0, 1], [0, -1]]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    global cnt
    cnt += 1
    visited[x][y] = True

    while queue:
        r, c = queue.popleft()
        for d in range(4):
            nr = r + dir[d][0]
            nc = c + dir[d][1]
            if n > nr >= 0 and m > nc >= 0 and data[nr][nc] == 0 and not visited[nr][nc]:
                visited[nr][nc] = True
                queue.append((nr, nc))


for row in range(n):
    for col in range(m):
        if data[row][col] == 0 and not visited[row][col]:
            bfs(row, col)

print(data)
print(cnt)
