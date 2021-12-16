n, m, k = map(int, input().split())
numbers = sorted(list(map(int, input().split())), reverse=True)

count = 0
sum = 0
for i in range(m):
    if count < 3:
        sum += numbers[0]
        count += 1
    else:
        sum += numbers[1]
        count = 0

print(sum)

# 방법 2:
# first = numbers[0]
# second = numbers[1]
#
# cnt = int(m / (k + 1)) * k
# cnt += m % (k+1)
#
# result = 0
# result += (count * first)
# result += (m - count) * second
#
# print(result)




