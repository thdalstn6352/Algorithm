import math

left, right = map(int, input().split())
n = 1000000

prime_number = [True for _ in range(n + 1)]
prime_number[1] = 0

for i in range(2, int(math.sqrt(n)) + 1):
    if prime_number[i]:
        j = 2
        while i * j <= n:
            prime_number[i * j] = False
            j += 1

for i in range(left, right + 1):
    if prime_number[i]:
        print(i)
