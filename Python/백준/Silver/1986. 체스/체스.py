import sys
input = sys.stdin.read().strip().splitlines()

N, M = map(int, input[0].split())

qN, *queens = map(int, input[1].split())
kN, *knights = map(int, input[2].split())
pN, *pawns = map(int, input[3].split())

board = [[0] * M for _ in range(N)]

qDirs = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
kDirs = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2)]

for i in range(pN):
  x, y = pawns[i * 2] - 1, pawns[i * 2 + 1] - 1
  board[x][y] = 1

for i in range(kN):
  x, y = knights[i*2] - 1, knights[i*2+1] - 1
  board[x][y] = 1

for i in range(qN):
  x, y = queens[i*2] - 1, queens[i*2+1] - 1
  board[x][y] = 1

def markQMoves(x, y):
  for dx, dy in qDirs:
    nx, ny = x + dx, y + dy
    while 0 <= nx < N and 0 <= ny < M:
      if board[nx][ny] == 1:
        break
      board[nx][ny] = -1
      nx += dx
      ny += dy

def markKMoves(x, y):
  for dx, dy in kDirs:
    nx, ny = x + dx, y +dy
    if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
      board[nx][ny] = -1

for i in range(kN):
  x, y = knights[i*2] - 1, knights[i*2+1]-1
  markKMoves(x, y)

for i in range(qN):
  x, y = queens[i*2] - 1, queens[i*2+1] - 1
  markQMoves(x, y)

safeCount = 0
for i in range(N):
  for j in range(M):
    if board[i][j] == 0:
      safeCount += 1

print(safeCount)