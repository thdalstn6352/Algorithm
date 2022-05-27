import sys
input = sys.stdin.readline

T = int(input().rstrip())


def find(a):
    if parents[a] == a:
        return a
    return parents[a]


def getDepth(target):
    depth = 0
    while True:
        if target == parents[target]:
            break
        depth += 1
        target = find(target)
    return depth


def lca(targetA, depthA, targetB, depthB):
    if depthA < depthB:
        while depthA != depthB:
            targetB = find(targetB)
            depthB -= 1
    elif depthA > depthB:
        while depthA != depthB:
            targetA = find(targetA)
            depthA -= 1

    while targetA != targetB:
        targetA = find(targetA)
        targetB = find(targetB)

    return targetA


for _ in range(T):
    n = int(input().rstrip())
    parents = [i for i in range(n + 1)]

    for _ in range(n - 1):
        a, b = map(int, input().split())
        parents[b] = a

    target_a, target_b = map(int, input().split())
    print(lca(target_a, getDepth(target_a), target_b, getDepth(target_b)))

