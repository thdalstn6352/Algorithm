
n, m = map(int, input().split())

max_number = 0

for _ in range(n):
    min_data = min(list(map(int, input().split())))
    max_number = max(max_number, min_data)

print(max_number)
