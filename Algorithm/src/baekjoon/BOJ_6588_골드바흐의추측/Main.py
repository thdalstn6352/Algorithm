import math, sys
input = sys.stdin.readline


def isSosu(value):
    for i in range(2, n):
        if array[i] and array[value - i]:
            return i, value - i


n = 1000001
array = [True for _ in range(n)]

for i in range(2, int(math.sqrt(n))):
    if array[i]:
        for j in range(i * 2, n, i):
            if array[j]:
                array[j] = False


while True:
    num = int(input())
    if num == 0:
        break
    x, y = isSosu(num)
    print("%d = %d + %d" % (num, x, y))

