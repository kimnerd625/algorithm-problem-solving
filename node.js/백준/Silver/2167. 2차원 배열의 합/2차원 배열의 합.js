const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

let board = [new Array(M + 1).fill(0)]; // 초기 배열

for (let i = 1; i <= N; i++) {
  board.push([0, ...input[i].split(" ").map(Number)]);
}

let k = Number(input[N + 1]); // 쿼리의 수 (K)
let queries = []; // 각 쿼리 정보 배열

for (let line = N + 2; line < N + 2 + k; line++) {
  let [i, j, x, y] = input[line].split(" ").map(Number);
  queries.push([i, j, x, y]);
}

let sum = [];
for (let i = 0; i <= N; i++) {
  sum.push(new Array(M + 1).fill(0));
}

for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= M; j++) {
    sum[i][j] = board[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
  }
}

for (let index = 0; index < k; index++) {
  let [i, j, x, y] = queries[index];

  let current = sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1];
  console.log(current);
}
