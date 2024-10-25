const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = ["5 7 3", "0 2 4 4", "1 1 2 5", "4 0 6 2"];

let idx = 0;
const [M, N, K] = input[idx].split(" ").map(Number);
idx++;

const board = Array(M)
  .fill()
  .map(() => Array(N).fill(0));

for (let k = 0; k < K; k++) {
  const [fc, fr, tc, tr] = input[idx].split(" ").map(Number);
  idx++;

  for (let r = fr; r < tr; r++) {
    for (let c = fc; c < tc; c++) {
      board[r][c] = 1;
    }
  }
}

const visited = Array(M)
  .fill()
  .map(() => Array(N).fill(false));

let count = 0;
let areaArr = [];
const q = [];
const dr = [-1, 1, 0, 0];
const dc = [0, 0, -1, 1];
for (let r = 0; r < M; r++) {
  for (let c = 0; c < N; c++) {
    if (board[r][c] == 0 && !visited[r][c]) {
      count++;
      let tempArea = 1;
      visited[r][c] = true;
      q.push([r, c]);

      while (q.length != 0) {
        const [r, c] = q.shift();
        for (let i = 0; i < 4; i++) {
          let nr = r + dr[i];
          let nc = c + dc[i];

          if (
            nr >= 0 &&
            nc >= 0 &&
            nr < M &&
            nc < N &&
            board[nr][nc] == 0 &&
            !visited[nr][nc]
          ) {
            visited[nr][nc] = true;
            tempArea++;
            q.push([nr, nc]);
          }
        }
      }

      areaArr.push(tempArea);
    }
  }
}

console.log(count);
console.log(areaArr.sort((a, b) => a - b).join(" "));
