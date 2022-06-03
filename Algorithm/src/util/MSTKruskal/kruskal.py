v, e = map(int, input().split())

parent = [0] * (v + 1)
edges = []
result = 0


def make():
    for i in range(1, v + 1):
        parent[i] = i


def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


for _ in range(e):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()
make()

for edge in edges:
    cost, a, b = edge

    if find(parent, a) == find(parent, b):
        continue
    union(a, b)
    result += cost

print(result)




