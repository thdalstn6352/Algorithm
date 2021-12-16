n = int(input())

data = list()

for _ in range(n):
    info = tuple(input().split())
    data.append(info)

result = sorted(data, key=lambda x: x[1])

for i in result:
    print(i[0], end=" ")