const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const [qN, ...queens] = input[1].split(" ").map(Number);
const [kN, ...knights] = input[2].split(" ").map(Number);
const [pN, ...pawns] = input[3].split(" ").map(Number);

let board = Array(N)
  .fill()
  .map(() => Array(M).fill(0)); // 0: 안전한 칸, 1: 말이 있는 칸, -1: 공격받는 칸

// 퀸의 이동 방향 (상하좌우 + 대각선)
const qDirs = [
  [-1, 0], [1, 0], [0, -1], [0, 1], // 상, 하, 좌, 우
  [-1, -1], [-1, 1], [1, -1], [1, 1] // 대각선
];

// 나이트의 이동 방향 (L자 형태)
const kDirs = [
  [-2, -1], [-2, 1], [2, -1], [2, 1],
  [-1, -2], [-1, 2], [1, -2], [1, 2]
];

// 말들의 위치를 먼저 표시 (퀸, 나이트, 폰)
for (let i = 0; i < pN; i++) {
  const x = pawns[i * 2] - 1;
  const y = pawns[i * 2 + 1] - 1;
  board[x][y] = 1; // 폰의 위치를 1로 표시
}

for (let i = 0; i < kN; i++) {
  const x = knights[i * 2] - 1;
  const y = knights[i * 2 + 1] - 1;
  board[x][y] = 1; // 나이트의 위치를 1로 표시
}

for (let i = 0; i < qN; i++) {
  const x = queens[i * 2] - 1;
  const y = queens[i * 2 + 1] - 1;
  board[x][y] = 1; // 퀸의 위치를 1로 표시
}

// 퀸의 이동 경로 처리
function markQMoves(x, y) {
  for (const [dx, dy] of qDirs) {
    let nx = x + dx;
    let ny = y + dy;
    
    // 퀸이 장애물(다른 말이나 폰)을 만날 때까지 이동
    while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
      if (board[nx][ny] === 1) break; // 다른 말(퀸, 나이트, 폰)이 있으면 중단
      board[nx][ny] = -1; // 퀸의 공격 범위를 -1로 표시
      nx += dx;
      ny += dy;
    }
  }
}

// 나이트의 이동 경로 처리
function markKMoves(x, y) {
  for (const [dx, dy] of kDirs) {
    const nx = x + dx;
    const ny = y + dy;
    if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] === 0) {
      board[nx][ny] = -1; // 나이트의 공격 범위를 -1로 표시
    }
  }
}

// 나이트의 공격 범위 반영
for (let i = 0; i < kN; i++) {
  const x = knights[i * 2] - 1;
  const y = knights[i * 2 + 1] - 1;
  markKMoves(x, y); // 나이트의 공격 경로 처리
}

// 퀸의 공격 범위 반영
for (let i = 0; i < qN; i++) {
  const x = queens[i * 2] - 1;
  const y = queens[i * 2 + 1] - 1;
  markQMoves(x, y); // 퀸의 공격 경로 처리
}

// 안전한 칸 계산
let safeCount = 0;
for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (board[i][j] === 0) {
      safeCount++; // 공격받지 않는 칸이면 카운트 증가
    }
  }
}

console.log(safeCount);