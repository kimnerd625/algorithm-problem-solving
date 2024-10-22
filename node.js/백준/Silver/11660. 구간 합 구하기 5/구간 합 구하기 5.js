const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

let idx = 0;
const [N, M] = input[idx].split(" ").map(Number);
idx++;

// 원본 배열
const board = [];

for (let i = 0; i < N; i++) {
  board.push(input[idx].split(" ").map(Number));
  idx++;
}

// 누적 합 배열
const sumBoard = new Array(N).fill().map(() => new Array(N).fill(0));

// 누적 합 배열 생성
for (let r = 0; r < N; r++) {
  for (let c = 0; c < N; c++) {
    sumBoard[r][c] = board[r][c];
    if (r > 0) sumBoard[r][c] += sumBoard[r - 1][c];
    if (c > 0) sumBoard[r][c] += sumBoard[r][c - 1];
    if (r > 0 && c > 0) sumBoard[r][c] -= sumBoard[r - 1][c - 1];
  }
}

// 각 질의에 대해 합 계산
for (let t = 0; t < M; t++) {
  const [x1, y1, x2, y2] = input[idx].split(" ").map(Number);
  idx++;

  let answer = sumBoard[x2 - 1][y2 - 1];
  if (x1 > 1) answer -= sumBoard[x1 - 2][y2 - 1];
  if (y1 > 1) answer -= sumBoard[x2 - 1][y1 - 2];
  if (x1 > 1 && y1 > 1) answer += sumBoard[x1 - 2][y1 - 2];

  console.log(answer);
}
