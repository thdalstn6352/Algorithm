v, e = map(int, input().split())
parent = [0] * (v + 1)


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def make():
    for i in range(1, v + 1):
        parent[i] = i


make()

for i in range(e):
    a, b = map(int, input().split())
    union(a, b)

print('각 원소가 속한 집합: ', end="")
for i in range(1, v + 1):
    print(find(i), end=" ")

print()

print('부모 테이블: ', end="")
for i in range(1, v + 1):
    print(parent[i], end=" ")

