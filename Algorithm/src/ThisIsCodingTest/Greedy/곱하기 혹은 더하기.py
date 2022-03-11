data = input()

result = 0
num = int(data[0])

for i in range(1, len(data)):
    num2 = int(data[i])

    if num + num2 > num * num2:
        num = num + num2
    else:
        num = num * num2

print(num)




