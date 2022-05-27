n = int(input())

# 각 숫자별 최소 횟수 저장
memo = [0] * (n + 1)


for i in range(2, n + 1):

    # 1로 뺄 경우
    memo[i] = memo[i - 1] + 1

    # 3으로 나누어 떨어질 경우
    if i % 3 == 0:
        memo[i] = min(memo[i], memo[i // 3] + 1)

    # 2로 나누어 떨어질 경우
    if i % 2 == 0:
        memo[i] = min(memo[i], memo[i // 2] + 1)


print(memo)
print(memo[n])