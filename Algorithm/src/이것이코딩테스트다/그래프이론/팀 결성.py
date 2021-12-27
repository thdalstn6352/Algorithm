n, m = map(int, input().split())

parent = [0] * (n + 1)


def make():
    for i in range(n + 1):
        parent[i] = i


def find(a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


make()

for _ in range(m):
    flag, a, b = map(int, input().split())

    if flag == 0:
        union(a, b)
    else:
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")


