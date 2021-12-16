array = [7, 5, 9, 9, 2, 3, 0, 2, 4, 8, 6, 5, 2, 9]

count = [0] * (max(array) + 1)
result = list()

for i in array:
    count[i] += 1

for i in range(len(count)):
    for j in range(count[i]):
        result.append(i)

print(count)
print(result)
