from collections import deque

n, m = map(int, input().split())
visited = [[False] * m for _ in range(n)]
data = list()
for _ in range(n):
    data.append(list(map(int, input())))

dir = [[-1, 0], [1, 0], [0, 1], [0, -1]]
cnt = 0


def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    global cnt
    cnt += 1
    data[i][j] = cnt
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx, ny = x + dir[d][0], y + dir[d][1]
            if 0 <= nx < n and 0 <= ny < m and data[nx][ny] == 0:
                data[nx][ny] = cnt
                queue.append((nx, ny))


for row in range(n):
    for col in range(m):
        if data[row][col] == 0:
            bfs(row, col)

print(data)
print(cnt)
