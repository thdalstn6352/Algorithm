import sys
input = sys.stdin.readline

n = int(input())
candy = [list(input().strip()) for _ in range(n)]

maxCount = 0


def checkWidth():
    global maxCount
    for r in range(n):
        countRow = 1  # 초기 개수를 1로 초기화
        for c in range(n - 1):
            if candy[r][c] == candy[r][c + 1]:  # 만약 같은 열의 사탕의 색이 같다면
                countRow += 1  # 사탕 개수 1 증가
                maxCount = max(maxCount, countRow)  # 증가시킨 값과 최대 사탕개수를 비교하여 큰값을 대입
            else:  # 만약 같은 열의 사탕 개수가 다르다면
                countRow = 1  # 개수를 1로 초기화


def checkHeight():
    global maxCount
    for r in range(n):
        countColumn = 1  # 초기 개수를 1로 초기화
        for c in range(n - 1):
            if candy[c][r] == candy[c + 1][r]:  # 만약 같은 행의 사탕의 색이 같다면
                countColumn += 1  # 사탕 개수를 1개씩 증가시켜주고
                maxCount = max(maxCount, countColumn)  # 증가시킨 값과 최대 사탕개수를 비교하여 큰값을 대입
            else:  # 만약 같은 행의 색이 다르다면
                countColumn = 1  # 개수를 1로 초기화


for row in range(n):
    for col in range(n - 1):
        # 행 비교
        if candy[row][col] != candy[row][col + 1]:
            candy[row][col], candy[row][col + 1] = candy[row][col+1], candy[row][col]
            checkWidth()
            checkHeight()
            candy[row][col], candy[row][col + 1] = candy[row][col + 1], candy[row][col]

        # 열 비교
        if candy[col][row] != candy[col + 1][row]:
            candy[col][row], candy[col + 1][row] = candy[col + 1][row], candy[col][row]
            checkWidth()
            checkHeight()
            candy[col][row], candy[col + 1][row] = candy[col + 1][row], candy[col][row]

print(maxCount)