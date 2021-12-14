n, m = map(int, input().split())

data = list()
for _ in range(n):
    data.append(list(map(int, input())))

visited = [[False] * m for _ in range(n)]
dir = [[-1 , 0], [1, 0], [0, -1], [0, 1]]
cnt = 0


def dfs(row, col):
    for d in range(len(dir)):
        nr, nc = row + dir[d][0], col + dir[d][1]
        if 0 <= nr < n and 0 <= nc < m and not visited[nr][nc] and data[nr][nc] == 0:
            visited[nr][nc] = True
            dfs(nr, nc)


for row in range(n):
    for col in range(m):
        if data[row][col] == 0 and not visited[row][col]:
            dfs(row, col)
            cnt += 1


print(cnt, end=" ")
