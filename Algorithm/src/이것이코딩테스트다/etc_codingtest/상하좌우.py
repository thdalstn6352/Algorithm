n = int(input())
dir = list(input().split())

# 0 : 우(R) / 1 : 좌(L) / 2 : 하(D) / 3 : 상(U)
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

data = dict()
data['R'] = 0
data['L'] = 1
data['D'] = 2
data['U'] = 3

current = [1, 1]

for d in dir:
    nx = current[0] + dx[data[d]]
    ny = current[1] + dy[data[d]]
    if 0 < nx < n + 1 and 0 < ny < n + 1:
        current = [nx, ny]
print(current[0], current[1])

