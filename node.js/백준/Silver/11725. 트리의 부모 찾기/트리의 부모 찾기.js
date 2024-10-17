const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = ["7", "1 6", "6 3", "3 5", "4 1", "2 4", "4 7"];

const N = parseInt(input[0]);

const board = Array(N + 1)
  .fill()
  .map(() => Array());
const visited = Array(N + 1).fill(false);
const parent = Array(N + 1).fill(0);

for (let i = 1; i <= N - 1; i++) {
  const [a, b] = input[i].split(" ").map(Number);
  board[a].push(b);
  board[b].push(a);
}

let q = [];
visited[1] = true;
for (let b1 of board[1]) {
  visited[b1] = true;
  parent[b1] = 1;
  q.push(b1);
  while (q.length != 0) {
    const temp = q.shift();
    for (let b2 of board[temp]) {
      if (!visited[b2]) {
        visited[b2] = true;
        parent[b2] = temp;
        q.push(b2);
      }
    }
  }
}

parent.shift();
parent.shift();

console.log(parent.join("\n"));
