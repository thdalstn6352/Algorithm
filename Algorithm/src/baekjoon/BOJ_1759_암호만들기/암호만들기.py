from itertools import *

L, C = map(int, input().split())
data = sorted(list(input().split()))
vowel = ['a', 'e', 'i', 'o', 'u']

for i in list(combinations(data, L)):
    vowel_cnt = 0
    consonant_cnt = 0
    for j in i:
        if j in vowel:
            vowel_cnt += 1
        else:
            consonant_cnt += 1
    if vowel_cnt >= 1 and consonant_cnt >= 2:
        print("".join(i))

