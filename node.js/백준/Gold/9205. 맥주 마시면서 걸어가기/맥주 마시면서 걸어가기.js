const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let idx = 0;
const T = parseInt(input[idx]);
idx++;

for (let t = 0; t < T; t++) {
  const N = parseInt(input[idx]);
  idx++;
  const [sx, sy] = input[idx].split(" ").map(Number);
  idx++;
  const conv = [];
  for (let n = 0; n < N; n++) {
    conv.push(input[idx].split(" ").map(Number));
    idx++;
  }
  const [px, py] = input[idx].split(" ").map(Number);
  idx++;

  let q = [];
  q.push([sx, sy]);

  let convVisited = Array(conv.length).fill(false);
  let reachable = false;

  while (q.length != 0) {
    const [curx, cury] = q.shift();

    if (isAbleToRock(curx, cury, px, py)) {
      console.log("happy");
      reachable = true;
      break;
    }

    for (let i = 0; i < conv.length; i++) {
      if (!convVisited[i]) {
        const [convx, convy] = conv[i];
        if (isAbleToRock(curx, cury, convx, convy)) {
          q.push([convx, convy]);
          convVisited[i] = true;
        }
      }
    }
  }

  if (!reachable) {
    console.log("sad");
  }
}

// isAbleToRock  : 현위치 -> 목적지 가능한지 여부 확인
function isAbleToRock(curx, cury, px, py) {
  if (Math.abs(curx - px) + Math.abs(cury - py) <= 1000) {
    return true;
  }
  return false;
}
