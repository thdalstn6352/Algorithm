import sys
input = sys.stdin.readline

n, m = map(int, input().split())

parents = [0] * (n + 1)
edges = []
for i in range(n + 1):
    parents[i] = i


def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parents[b] = a
    else:
        parents[a] = b


for _ in range(m):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

result = 0
max_dist = 0
for edge in edges:
    cost, a, b = edge
    if find(a) == find(b):
        continue
    union(a, b)
    max_dist = max(max_dist, cost)
    result += cost

print(result - max_dist)