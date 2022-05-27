import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())
parents = [0] * (n + 1)


def make():
    for i in range(n + 1):
        parents[i] = i


def find(a):
    if parents[a] == a:
        return a
    parents[a] = find(parents[a])
    return parents[a]


def union(a, b):
    pa, pb = find(a), find(b)
    if pa == pb:
        return
    else:
        if pa < pb:
            parents[pb] = pa
        else:
            parents[pa] = pb

make()

for _ in range(m):
    op, a, b = map(int, input().split())
    if op == 0:
        union(a, b)
    else:
        if find(a) == find(b):
            print('YES\n')
        else:
            print('NO\n')





