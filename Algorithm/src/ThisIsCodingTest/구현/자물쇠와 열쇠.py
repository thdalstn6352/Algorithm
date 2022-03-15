def solution(key, lock):
    row = len(lock)
    col = len(lock[0])

    new_lock = [[0] * (row * 3) for _ in range(col * 3)]

    for r in range(row):
        for c in range(col):
            new_lock[r + row][c + col] = lock[r][c]

    for d in range(4):
        new_key = rotation_90_degree(key)
        for x in range(row * 2):
            for y in range(col * 2):
                for i in range(row):
                    for j in range(col):
                        new_lock[x + i][y + j] += new_key[i][j]

def rotation_90_degree(matrix):
    # 행의 개수
    n = len(matrix)
    # 열의 개수
    m = len(matrix[0])

    new_matrix = [[0] * n for _ in range(m)]

    for row in range(m):
        for col in range(n):
            new_matrix[row][col] = matrix[n - 1 - col][row]
    return new_matrix