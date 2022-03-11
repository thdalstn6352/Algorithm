data = input()

count0 = 0
count1 = 0

# num = int(data[0])
if int(data[0]) == 0:
    count1 += 1
else:
    count0 += 1

for i in range(len(data) - 1):

    if data[i] != data[i + 1]:
        if int(data[i + 1]) == 0:
            count1 += 1
        else:
            count0 += 1


print(min(count0, count1))