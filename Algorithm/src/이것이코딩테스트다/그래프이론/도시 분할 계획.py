n, m = map(int, input().split())
edges = []
parents = [0] * (n + 1)
result = []

def make():
    for i in range(1, n + 1):
        parents[i] = i


def find(a):
    if parents[a] != a:
        parents[a] = find(parents[a])
    return parents[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parents[b] = a
    else:
        parents[a] = b


for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))


edges.sort()
make()

for edge in edges:
    cost, a, b = edge
    if find(a) == find(b):
        continue
    union(a, b)
    result.append(cost)

print(sum(result) - max(result))
