from itertools import combinations
import sys

input = sys.stdin.readline

people = list()

for _ in range(9):
    people.append(int(input().strip()))

comb_list = list(combinations(people, 7))

for i in comb_list:
    if sum(i) == 100:
        answer = list(i)
        break

for num in sorted(answer):
    print(num)