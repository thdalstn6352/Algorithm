from collections import deque
import sys
input = sys.stdin.readline
k = int(input())


def bfs(graph, start):
    queue = deque()
    queue.append(start)
    visited[start] = 1
    while queue:
        v = queue.popleft()
        for n in graph[v]:
            if visited[n] == 0:
                queue.append(n)
                visited[n] = -1 * visited[v]
            else:
                if visited[n] == visited[v]:
                    return False
    return True


for _ in range(k):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    visited = [0] * (V + 1)
    answer = True
    for _ in range(E):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    for i in range(1, V + 1):
        if visited[i] == 0:
            if not bfs(graph, i):
                answer = False
                break

    print("YES" if answer else "NO")
