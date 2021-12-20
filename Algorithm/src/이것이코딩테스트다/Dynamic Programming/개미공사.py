n = int(input())

array = list(map(int, input().split()))

data = [0] * 100

data[0] = array[0]
data[1] = max(array[0], array[1])
for i in range(2, n):
    data[i] = max(data[i - 1], data[i - 2] + array[i])

print(data[n - 1])
