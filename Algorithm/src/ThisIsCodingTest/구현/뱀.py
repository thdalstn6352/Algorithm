from collections import deque

n = int(input())
k = int(input())

apple = deque()
direction = deque()
dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]

for _ in range(k):
    r, c = map(int, input().split())
    apple.append((r, c))

l = int(input())

for _ in range(l):
    x, c = input().split()
    direction.append((int(x), c))


graph = [[0] * n for _ in range(n)]
graph[0][0] = 1

for d in apple:
    r, c = d
    graph[r-1][c-1] = 2

index = 0
count = 0
dir_index = 0
snake = deque()
now = (0, 0)
snake.append(now)

while True:
    nr, nc = now[0] + dir[dir_index][0], now[1] + dir[dir_index][1]
    if nr < 0 or nr >= n or nc < 0 or nc >= n or graph[nr][nc] == 1:
        count += 1
        break
    else:
        if graph[nr][nc] == 2:
            graph[nr][nc] = 1
            snake.append((nr, nc))
        else:
            graph[nr][nc] = 1
            snake.append((nr, nc))
            tailx, taily = snake.popleft()
            graph[tailx][taily] = 0

    now = (nr, nc)
    count += 1

    if index < l and count == direction[index][0]:
        if direction[index][1] == 'L':
            dir_index -= 1
            if dir_index == -1:
                dir_index = 3
        else:
            dir_index += 1
            if dir_index == 4:
                dir_index = 0
        index += 1
print(count)

