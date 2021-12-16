from collections import deque

n, m = map(int, input().split())

data = list()
for _ in range(n):
    data.append(list(map(int, input())))

dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]

visited = [[False] * m for _ in range(n)]


def bfs():
    queue = deque()
    queue.append((0, 0, 1))
    visited[0][0] = True

    while queue:
        x, y, cnt = queue.popleft()
        for d in range(4):
            nx, ny = x + dir[d][0], y + dir[d][1]
            if nx == n - 1 and ny == m - 1:
                return cnt + 1
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and data[nx][ny] == 1:
                queue.append((nx, ny, cnt+1))
                visited[nx][ny] = True


print(bfs())