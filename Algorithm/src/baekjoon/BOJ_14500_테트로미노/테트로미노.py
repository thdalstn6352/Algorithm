import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [[] for _ in range(N)]
visited = [[False] * M for _ in range(N)]
dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
value = 0


def dfs(row, col, idx, dsum):
    global value
    if idx == 3:
        value = max(value, dsum)
        return dsum

    for d in range(len(dir)):
        nr = row + dir[d][0]
        nc = col + dir[d][1]

        if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc]:
            visited[nr][nc] = True
            dfs(nr, nc, idx + 1, dsum + board[nr][nc])
            visited[nr][nc] = False


def another(row, col):
    global value

    for d in range(len(dir)):
        nValue = board[row][col]
        for i in range(3):
            j = (d + i) % 4
            nr = row + dir[j][0]
            nc = col + dir[j][1]

            if not (0 <= nr < N and 0 <= nc < M):
                nValue = 0
                break
            nValue += board[nr][nc]
        value = max(value, nValue)


for i in range(N):
    board[i] = list(map(int, input().split()))

for r in range(N):
    for c in range(M):
        visited[r][c] = True
        dfs(r, c, 0, board[r][c])
        visited[r][c] = False
        another(r, c)


print(value)