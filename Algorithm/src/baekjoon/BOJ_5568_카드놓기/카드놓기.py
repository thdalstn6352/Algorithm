import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
k = int(input())

numbers = list()

for _ in range(n):
    numbers.append(int(input()))

result = list(permutations(numbers, k))
number = list()
for data in result:
    value = ""
    for val in data:
        value += str(val)
    number.append(int(value))

print(len(set(number)))