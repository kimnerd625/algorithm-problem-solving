const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = [
//   "1 1",
//   "0",
//   "2 2",
//   "0 1",
//   "1 0",
//   "3 2",
//   "1 1 1",
//   "1 1 1",
//   "5 4",
//   "1 0 1 0 0",
//   "1 0 0 0 0",
//   "1 0 1 0 1",
//   "1 0 0 1 0",
//   "5 4",
//   "1 1 1 0 1",
//   "1 0 1 0 1",
//   "1 0 1 0 1",
//   "1 0 1 1 1",
//   "5 5",
//   "1 0 1 0 1",
//   "0 0 0 0 0",
//   "1 0 1 0 1",
//   "0 0 0 0 0",
//   "1 0 1 0 1",
//   "0 0",
// ];

const dc = [-1, 0, 1, -1, 1, -1, 0, 1];
const dr = [-1, -1, -1, 0, 0, 1, 1, 1];

let index = 0;
while (input[index] != "0 0") {
  const [M, N] = input[index].split(" ").map(Number);
  index++;

  const board = [];
  for (let i = 0; i < N; i++, index++) {
    board.push(input[index].split(" ").map(Number));
  }

  const visited = Array(N)
    .fill()
    .map(() => Array(M).fill(false));

  let answer = 0;
  const q = [];

  for (let r = 0; r < N; r++) {
    for (let c = 0; c < M; c++) {
      if (board[r][c] == 1 && !visited[r][c]) {
        visited[r][c] = true;
        answer++;
        q.push([r, c]);

        while (q.length != 0) {
          const [r, c] = q.shift();

          for (let i = 0; i < 8; i++) {
            let nr = r + dr[i];
            let nc = c + dc[i];

            if (
              nr >= 0 &&
              nc >= 0 &&
              nr < N &&
              nc < M &&
              board[nr][nc] == 1 &&
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

  console.log(answer);
}
