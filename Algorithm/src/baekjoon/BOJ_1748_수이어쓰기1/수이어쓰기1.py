import math

n = int(input())

# 1 - 9 = 9
# 10 - 99 - 90
# 100 - 999 = 900

digit = [0] * 9
init_length = len(str(n))
length = 0

for i in range(1, 9):
    digit[i] = (9 * i * int(math.pow(10, i - 1)))

for j in range(init_length):
    length += digit[j]

# if n < 10:
#     print()
# else:
# print(digit)