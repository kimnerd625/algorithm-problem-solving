const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

const [M, N] = input[0].split(" ").map(Number);

const board = [];
for (let i = 1; i < input.length; i++) {
  board.push(input[i].split(" ").map(Number));
}

const visited = Array(N)
  .fill()
  .map(() => Array(M).fill(false));

const q = [];
let front = 0; // 큐에서 앞의 요소를 꺼내기 위한 인덱스

let answer = 0;

// 익은 토마토(1)들을 모두 큐에 넣고 방문 표시
for (let r = 0; r < N; r++) {
  for (let c = 0; c < M; c++) {
    if (board[r][c] == 1 && !visited[r][c]) {
      visited[r][c] = true;
      q.push([r, c, 0]); // [행, 열, 걸린 시간]
    }
  }
}

// BFS 탐색
while (front < q.length) {
  const [curR, curC, days] = q[front++];
  answer = days; // 마지막으로 업데이트된 날짜가 정답

  for (let i = 0; i < 4; i++) {
    const nr = curR + dr[i];
    const nc = curC + dc[i];

    if (
      nr >= 0 &&
      nr < N &&
      nc >= 0 &&
      nc < M &&
      !visited[nr][nc] &&
      board[nr][nc] == 0
    ) {
      visited[nr][nc] = true;
      board[nr][nc] = 1; // 토마토가 익음
      q.push([nr, nc, days + 1]);
    }
  }
}

// 익지 않은 토마토가 남아 있는지 확인
for (let r = 0; r < N; r++) {
  for (let c = 0; c < M; c++) {
    if (board[r][c] == 0) {
      console.log(-1);
      return;
    }
  }
}

console.log(answer);
