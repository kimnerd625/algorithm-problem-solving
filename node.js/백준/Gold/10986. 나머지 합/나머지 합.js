const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

const numArr = input[1].split(" ").map(Number);

let sumVal = 0;
const prefixSum = [0];

for (let n of numArr) {
  sumVal += n;
  prefixSum.push(sumVal);
}

let processed = []; // 누적 합 (prefix sum)을 M으로 나눈 나머지
let counter = {}; // 각 나머지 값에 대한 개수를 저장하고 있는 카운터

for (let i = 0; i <= N; i++) {
  processed[i] = prefixSum[i] % M;
  if (processed[i] in counter) counter[processed[i]] += 1;
  else counter[processed[i]] = 1;
}

let answer = 0;

for (let i = 0; i < M; i++) {
  if (i in counter) answer += parseInt((counter[i] * (counter[i] - 1)) / 2);
}

console.log(answer);
