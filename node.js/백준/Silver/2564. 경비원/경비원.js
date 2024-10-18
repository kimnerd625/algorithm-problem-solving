const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// dir : 1 - 북, 2 - 남, 3 - 서, 4 - 동

let idx = 0;

const [W, H] = input[idx].split(" ").map(Number);
idx++;

const T = parseInt(input[idx]);
idx++;

const stores = [];

for (let t = 0; t < T; t++) {
  const [dir, dist] = input[idx].split(" ").map(Number);
  stores.push([dir, dist]);
  idx++;
}

const [sDir, sDist] = input[idx].split(" ").map(Number);

/**
 * 같은 방위에 있을 때,
 * 오른쪽에 있을 때, 1 -> 3, 2 -> 3, 3 -> 1, 3 -> 2,
 * 왼쪽에 있을 때,
 * 맞은 편에 있을 때,
 */

let answer = 0;

for (let [tDir, tDist] of stores) {
  if (sDir == tDir) {
    answer += Math.abs(sDist - tDist);
    continue;
  }

  if (tDir == 1) {
    if (sDir == 2) {
      answer += Math.min(H + tDist + sDist, H + W - tDist + W - sDist);
      continue;
    } else if (sDir == 3) {
      answer += tDist + sDist;
      continue;
    } else if (sDir == 4) {
      answer += W - tDist + sDist;
      continue;
    }
  }

  if (tDir == 2) {
    if (sDir == 1) {
      answer += Math.min(H + tDist + sDist, H + W - tDist + W - sDist);
      continue;
    } else if (sDir == 3) {
      answer += tDist + H - sDist;
      continue;
    } else if (sDir == 4) {
      answer += W - tDist + H - sDist;
      continue;
    }
  }

  if (tDir == 3) {
    if (sDir == 1) {
      answer += sDist + tDist;
      continue;
    } else if (sDir == 2) {
      answer += sDist + H - tDist;
      continue;
    } else if (sDir == 4) {
      answer += Math.min(W + sDist + tDist, W + H - sDist + H - tDist);
      continue;
    }
  }

  if (tDir == 4) {
    if (sDir == 1) {
      answer += W - sDist + tDist;
      continue;
    } else if (sDir == 2) {
      answer += W - sDist + H - tDist;
      continue;
    } else if (sDir == 3) {
      answer += Math.min(W + sDist + tDist, W + H - sDist + H - tDist);
    }
  }
}

console.log(answer);
