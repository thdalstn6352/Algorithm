from itertools import combinations

n, m = map(int, input().split())
array = list(map(int, input().split()))

comb_result = list(combinations(array, 2))
count = 0

for x in comb_result:
    if x[0] != x[1]:
        count += 1

print(count)