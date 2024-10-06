const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ");
const [N, K] = input.map(Number);
const visited = Array(100001).fill(false);
const queue = [[N, 0]]; // [위치, 초]

let answer = -1;

while (queue.length) {
  const [p, sec] = queue.shift();

  // 목적지에 도달한 경우
  if (p === K) {
    answer = sec;
    break;
  }

  // 가능한 모든 이동 시도
  if (p * 2 <= 100000 && !visited[p * 2]) {
    visited[p * 2] = true;
    queue.push([p * 2, sec + 1]);
  }
  if (p + 1 <= 100000 && !visited[p + 1]) {
    visited[p + 1] = true;
    queue.push([p + 1, sec + 1]);
  }
  if (p - 1 >= 0 && !visited[p - 1]) {
    visited[p - 1] = true;
    queue.push([p - 1, sec + 1]);
  }
}

console.log(answer);
