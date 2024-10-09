const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

const graph = Array(N + 1)
  .fill()
  .map(() => new Array());

for (let t = 1; t < input.length; t++) {
  const [k, v] = input[t].split(" ").map(Number);
  graph[k].push(v);
  graph[v].push(k);
}

const visited = Array(N + 1).fill(false);
const q = [];

let answer = 0;

for (let n = 1; n <= N; n++) {
  if (!visited[n]) {
    visited[n] = true;
    answer++;
    q.push(n);
  }
  while (q.length != 0) {
    let cur = q.shift();
    for (let c of graph[cur]) {
      if (!visited[c]) {
        visited[c] = true;
        q.push(c);
      }
    }
  }
}

console.log(answer);
