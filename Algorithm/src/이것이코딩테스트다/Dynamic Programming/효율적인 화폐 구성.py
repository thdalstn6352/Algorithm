n, m = map(int, input().split())
money = list()
result = [10001] * 10001
result[0] = 0

for _ in range(n):
    money.append(int(input()))

for i in money:
    for j in range(i, m + 1):
        result[j] = min(result[j], result[j - i] + 1)
        # print(f"{i} / result[{j}] : {result[j]}")

print(result[m] if result[m] != 10001 else -1)
