n, m = map(int, input().split())
a, b, dir = map(int, input().split())
check = 0
move = 1

isVisited = [[0] * m for _ in range(n)]
# print(isVisited)
isVisited[a][b] = 1

#     북  동  남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

board = list()
for _ in range(n):
    board.append(list(map(int, input().split())))

while True:
    temp = dir
    dir = dir - 1
    if dir == -1:
        dir = 3

    na = a + dx[dir]
    nb = b + dy[dir]

    if isVisited[na][nb] != 1 and board[na][nb] != 1:
        isVisited[na][nb] = 1
        a, b = na, nb
        check = 0
        move += 1
        continue
    else:
        check += 1

    if check == 4:
        na = a - dx[temp]
        nb = b - dy[temp]
        if board[na][nb] == 1:
            break
        a, b = na, nb
        check = 0


print(move)
