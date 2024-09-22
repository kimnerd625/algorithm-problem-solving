const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

let board = [];

for (let i = 1; i <= N; i++) {
  board.push(input[i]);
}

const cDir = [
  [-1, 0], // 위
  [1, 0], // 아래
  [0, -1], // 왼쪽
  [0, 1], // 오른쪽
];

let answer = [];
let markedBoard = Array.from({ length: N }, () => Array(M).fill(false)); // 십자가를 표시할 배열

for (let r = 1; r < N - 1; r++) {
  // 십자가는 최소 3x3에서 성립하므로 경계 제외
  for (let c = 1; c < M - 1; c++) {
    if (board[r][c] !== "*") continue;

    let maxCrossSize = Math.min(r, c, N - r - 1, M - c - 1); // 십자가의 최대 크기 계산
    let crossSize = 0;

    // 가능한 최대 크기까지 크기를 늘려가며 십자가 만들기
    for (let size = 1; size <= maxCrossSize; size++) {
      let valid = true;
      for (let i = 0; i < cDir.length; i++) {
        let nr = r + cDir[i][0] * size;
        let nc = c + cDir[i][1] * size;
        if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] !== "*") {
          valid = false;
          break;
        }
      }

      if (valid) {
        crossSize = size; // 십자가 크기 갱신
      } else {
        break; // 더 이상 십자가를 확장할 수 없으면 중단
      }
    }

    if (crossSize > 0) {
      answer.push([r + 1, c + 1, crossSize]); // 1-based 인덱스 저장
      markedBoard[r][c] = true;

      // 십자가 팔 부분 표시
      for (let i = 0; i < cDir.length; i++) {
        for (let s = 1; s <= crossSize; s++) {
          let nr = r + cDir[i][0] * s;
          let nc = c + cDir[i][1] * s;
          markedBoard[nr][nc] = true;
        }
      }
    }
  }
}

// 모든 '*'이 십자가로 덮였는지 확인
let isValid = true;
for (let r = 0; r < N; r++) {
  for (let c = 0; c < M; c++) {
    if (board[r][c] === "*" && !markedBoard[r][c]) {
      isValid = false;
      break;
    }
  }
  if (!isValid) break;
}

if (!isValid) {
  console.log(-1);
} else {
  console.log(answer.length);
  for (let [r, c, size] of answer) {
    console.log(r, c, size);
  }
}
