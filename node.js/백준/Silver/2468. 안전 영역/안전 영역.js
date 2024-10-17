const input = require("fs")
 .readFileSync("/dev/stdin")
 .toString()
 .trim()
 .split("\n");

const N = parseInt(input[0]);

let board = [];
let maxLevel = 1;

const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];

for (let t = 1; t <= N; t++) {
  board.push(input[t].split(" ").map(Number));
  let temp = board[t - 1].reduce((max, cur) => Math.max(max, cur), 0);
  maxLevel = Math.max(maxLevel, temp);
}

let answer = 1;
let level = 1;

while (level <= maxLevel) {
  let visited = Array(N)
    .fill()
    .map(() => Array(N).fill(false));

  let q = [];
  let tempVal = 0;
  for (let r = 0; r < N; r++) {
    for (let c = 0; c < N; c++) {
      if (board[r][c] > level && !visited[r][c]) {
        tempVal++;
        visited[r][c] = true;
        q.push([r, c]);
        while (q.length != 0) {
          let [r, c] = q.shift();
          for (let i = 0; i < 4; i++) {
            let nr = r + dr[i];
            let nc = c + dc[i];

            if (
              nr >= 0 &&
              nc >= 0 &&
              nr < N &&
              nc < N &&
              board[nr][nc] > level &&
              !visited[nr][nc]
            ) {
              visited[nr][nc] = true;

              q.push([nr, nc]);
            }
          }
        }
      }
    }
  }

  answer = Math.max(answer, tempVal);
  level++;
}

console.log(answer);
