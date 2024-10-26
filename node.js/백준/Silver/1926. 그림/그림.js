const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = [
//   "6 5",
//   "1 1 0 1 1",
//   "0 1 1 0 0",
//   "0 0 0 0 0",
//   "1 0 1 1 1",
//   "0 0 1 1 1",
//   "0 0 1 1 1",
// ];

let idx = 0;
const [N, M] = input[idx].split(" ").map(Number);
idx++;

const board = [];

const visited = Array(N)
  .fill()
  .map(() => Array(M).fill(false));

for (let i = 0; i < N; i++) {
  board.push(input[idx].split(" ").map(Number));
  idx++;
}

const q = [];
let count = 0;
let maxPic = -Infinity;

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

for (let r = 0; r < N; r++) {
  for (let c = 0; c < M; c++) {
    if (board[r][c] == 1 && !visited[r][c]) {
      visited[r][c] = true;
      q.push([r, c]);
      count++;
      let area = 1;

      while (q.length != 0) {
        const [r, c] = q.shift();

        for (let i = 0; i < 4; i++) {
          const nr = r + dr[i];
          const nc = c + dc[i];

          if (
            nr >= 0 &&
            nr < N &&
            nc >= 0 &&
            nc < M &&
            board[nr][nc] == 1 &&
            !visited[nr][nc]
          ) {
            visited[nr][nc] = true;
            area++;
            q.push([nr, nc]);
          }
        }
      }

      maxPic = Math.max(maxPic, area);
    }
  }
}

console.log(count);
if (count == 0) {
  console.log(0);
} else {
  console.log(maxPic);
}
