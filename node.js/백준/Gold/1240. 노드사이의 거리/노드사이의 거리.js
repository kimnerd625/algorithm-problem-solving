const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = ["4 2", "2 1 2", "4 3 2", "1 4 3", "1 2", "3 2"];

let idx = 0;
const [N, M] = input[idx].split(" ").map(Number);
idx++;

const graph = Array(N + 1)
  .fill()
  .map(() => Array());

for (let i = 0; i < N - 1; i++) {
  const [v, w, dist] = input[idx].split(" ").map(Number);
  idx++;
  graph[v].push([w, dist]);
  graph[w].push([v, dist]);
}

for (let i = 0; i < M; i++) {
  const [x, y] = input[idx].split(" ").map(Number);
  idx++;

  let answer = 0;
  let isAnswerFound = false;
  let visited = Array(N + 1).fill(false);

  let q = [];
  q.push([x, 0]);
  visited[x] = true;

  while (q.length != 0) {
    let [a, tempDist] = q.shift();

    for (let tmp of graph[a]) {
      if (tmp[0] == y) {
        tempDist += tmp[1];
        isAnswerFound = true;
        break;
      }

      if (!visited[tmp[0]]) {
        visited[tmp[0]] = true;
        q.push([tmp[0], tempDist + tmp[1]]);
      }
    }

    if (isAnswerFound) {
      answer = tempDist;
      break;
    }
  }

  console.log(answer);
}
