n = int(input())

data = list(map(int, input().split()))

result = [0] * n

result[0] = data[0]
result[1] = max(data[0], data[1])
for i in range(2, n):
    result[i] = max(result[i - 1], result[i - 2] + data[i])
print(result[n - 1])

