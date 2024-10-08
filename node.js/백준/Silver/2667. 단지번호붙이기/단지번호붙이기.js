const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const N = parseInt(input[0]);

let board = [];

for (let i = 1; i <= N; i++) {
  board.push(input[i].split("").map(Number));
}

let visited = new Array(N).fill().map(() => new Array(N).fill(false));
let answerQ = [];
let q = [];
let count = 0;

let dr = [-1, 1, 0, 0];
let dc = [0, 0, -1, 1];

for (let r = 0; r < N; r++) {
  for (let c = 0; c < N; c++) {
    if (board[r][c] == 1 && !visited[r][c]) {
      q.push([r, c]);
      visited[r][c] = true;
      count++;
      BFS();
      answerQ.push(count);
      count = 0;
    }
  }
}

console.log(answerQ.length);
answerQ.sort((a, b) => a - b);
for (let a of answerQ) {
  console.log(a);
}

function BFS() {
  while (q.length != 0) {
    let [r, c] = q.shift();
    for (let i = 0; i < 4; i++) {
      let nr = r + dr[i];
      let nc = c + dc[i];

      if (
        nr >= 0 &&
        nr < N &&
        nc >= 0 &&
        nc < N &&
        board[nr][nc] == 1 &&
        !visited[nr][nc]
      ) {
        visited[nr][nc] = true;
        q.push([nr, nc]);
        count++;
      }
    }
  }
}
