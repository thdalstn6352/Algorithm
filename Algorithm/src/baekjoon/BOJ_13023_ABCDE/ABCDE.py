import sys
input = sys.stdin.readline

N, M = map(int, input().split(' '))

friends = [[] for _ in range(N)]
visited = [False] * N
isOk = False


def dfs(start, depth):
    global isOk
    if depth == 5:
        isOk = True
        return

    for friend in friends[start]:
        if not visited[friend]:
            visited[start] = True
            dfs(friend, depth + 1)
            visited[start] = False


for i in range(M):
    a, b = map(int, input().split(' '))
    friends[a].append(b)
    friends[b].append(a)

for i in range(N):
    if not isOk:
        dfs(i, 1)

if isOk:
    print(1)
else:
    print(0)


print(friends)
