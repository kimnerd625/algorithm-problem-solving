const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = [
//   "9",
//   "7 3",
//   "7",
//   "1 2",
//   "1 3",
//   "2 7",
//   "2 8",
//   "2 9",
//   "4 5",
//   "4 6",
// ];

let idx = 0;
const N = parseInt(input[idx]);
idx++;

const graph = Array(N + 1)
  .fill()
  .map(() => Array());

const visited = Array(N + 1).fill(false);

const [tX, tY] = input[idx].split(" ").map(Number);
idx++;

const M = parseInt(input[idx]);
idx++;

for (let i = 0; i < M; i++) {
  const [f, t] = input[idx].split(" ").map(Number);
  idx++;

  graph[f] = [...graph[f], t];
  graph[t] = [...graph[t], f];
}

const q = [];
let isAnswerFound = false;
q.push([graph[tX], 1]);
visited[tX] = true;

while (q.length != 0) {
  const [cur, level] = q.shift();

  for (let c of cur) {
    if (c == tY) {
      console.log(level);
      isAnswerFound = true;
      break;
    }

    if (!visited[c]) {
      visited[c] = true;
      q.push([graph[c], level + 1]);
    }
  }

  if (isAnswerFound) {
    break;
  }
}

if (!isAnswerFound) {
  console.log(-1);
}
