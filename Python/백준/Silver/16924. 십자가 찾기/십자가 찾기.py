import sys

input = sys.stdin.read().strip().splitlines()

N, M = map(int, input[0].split())

board = [input[i] for i in range(1, N + 1)]

cDir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

answer = []
markedBoard = [[False] * M for _ in range(N)]

for r in range(1, N - 1):
  for c in range(1, M - 1):
    if board[r][c] != "*":
      continue

    maxCrossSize = min(r, c, N - r - 1, M - c - 1)
    crossSize = 0

    for size in range(1, maxCrossSize + 1):
      valid = True
      for dr, dc in cDir:
        nr = r + dr * size
        nc = c + dc * size
        if nr < 0 or nr >= N or nc <0 or nc >= M or board[nr][nc] != "*":
          valid = False
          break
      
      if valid:
        crossSize = size
      else:
        break
    
    if crossSize > 0:
      answer.append((r + 1, c + 1, crossSize))
      markedBoard[r][c] = True
    
      for dr, dc in cDir:
        for s in range(1, crossSize + 1):
          nr = r + dr * s
          nc = c + dc * s
          markedBoard[nr][nc] = True

isValid = True
for r in range(N):
  for c in range(M):
    if board[r][c] == "*" and not markedBoard[r][c]:
      isValid = False
      break
  
  if not isValid:
    break

if not isValid:
  print(-1)
else:
  print(len(answer))
  for r, c, size in answer:
    print(r, c, size)