import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    age, name = input().split()
    arr.append([int(age), name])

arr.sort(key=lambda x: x[0])

for data in arr:
    print(data[0], data[1])