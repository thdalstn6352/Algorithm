n = input()

dx = [2, 2, -2, -2, -1, 1, -1, 1]
dy = [-1, 1, -1, 1, 2, 2, -2, -2]

x = int(n[1])
y = ord(n[0]) - 96

count = 0

for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 < nx < 9 and 0 < ny < 9:
        count += 1

print(count)