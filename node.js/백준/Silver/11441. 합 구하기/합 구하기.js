const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const N = parseInt(input[0]);

const numArr = input[1].split(" ").map(Number);

let sumVal = 0;
const prefixSum = [0];

for (let n of numArr) {
  sumVal += n;
  prefixSum.push(sumVal);
}

const T = parseInt(input[2]);

for (let t = 3; t < 3 + T; t++) {
  const [from, to] = input[t].split(" ").map(Number);

  console.log((prefixSum[to] - prefixSum[from - 1]));
}
