array = [7, 6, 9, 0, 1, 3, 5, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j] < array[j - 1]:
            array[j - 1], array[j] = array[j], array[j - 1]
        else:
            break

print(array)