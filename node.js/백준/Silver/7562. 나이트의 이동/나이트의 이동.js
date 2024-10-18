const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

let idx = 0;
const T = parseInt(input[idx]);
idx++;

const dr = [-1, 1, -2, 2, -2, 2, -1, 1];
const dc = [-2, -2, -1, -1, 1, 1, 2, 2];

for (let t = 0; t < T; t++) {
  const I = parseInt(input[idx]);
  idx++;
  const [fr, fc] = input[idx].split(" ").map(Number);
  idx++;
  const [tr, tc] = input[idx].split(" ").map(Number);
  idx++;

  const visited = Array(I)
    .fill()
    .map(() => Array(I).fill(false));
  const q = [[fr, fc, 0]];
  visited[fr][fc] = true;
  let answer = -1;

  while (q.length != 0) {
    const [r, c, dist] = q.shift();
    if (r == tr && c == tc) {
      answer = dist;
      break;
    }
    for (let i = 0; i < 8; i++) {
      const nr = r + dr[i];
      const nc = c + dc[i];

      if (nr >= 0 && nc >= 0 && nr < I && nc < I && !visited[nr][nc]) {
        visited[nr][nc] = true;
        q.push([nr, nc, dist + 1]);
      }
    }
  }

  console.log(answer);
}
