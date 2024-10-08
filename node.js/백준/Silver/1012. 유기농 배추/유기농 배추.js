const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let dr = [-1, 1, 0, 0];
let dc = [0, 0, -1, 1];

const T = parseInt(input[0]);
let q = [];
let answer = 0;

for (let t = 0, i = 1; t < T, i < input.length; t++) {
  const [M, N, K] = input[i].split(" ").map(Number);
  i++;
  let board = Array(N)
    .fill()
    .map(() => new Array(M).fill(0));
  for (let j = 0; j < K; j++) {
    let [c, r] = input[i].split(" ").map(Number);
    board[r][c] = 1;
    i++;
  }

  let visited = Array(N)
    .fill()
    .map(() => new Array(M).fill(false));
  for (let r = 0; r < N; r++) {
    for (let c = 0; c < M; c++) {
      if (board[r][c] == 1 && visited[r][c] == false) {
        q.push([r, c]);
        answer++;
        bfs(N, M, board, visited);
      }
    }
  }

  console.log(answer);
  answer = 0;
}

function bfs(N, M, board, visited) {
  while (q.length != 0) {
    let [r, c] = q.shift();
    for (let i = 0; i < 4; i++) {
      let nr = r + dr[i];
      let nc = c + dc[i];

      if (
        nr >= 0 &&
        nr < N &&
        nc >= 0 &&
        nc < M &&
        !visited[nr][nc] &&
        board[nr][nc] == 1
      ) {
        visited[nr][nc] = true;

        q.push([nr, nc]);
      }
    }
  }
}
