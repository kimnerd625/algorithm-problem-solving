const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, S] = input[0].split(" ").map(Number);
const numList = input[1].split(" ").map(Number);

let start = 0;
let end = 0;
let currentSum = 0;
let minLength = Infinity;

while (end < N) {
  currentSum += numList[end];
  end++;

  while (currentSum >= S) {
    minLength = Math.min(minLength, end - start);
    currentSum -= numList[start];
    start++;
  }
}

console.log(minLength === Infinity ? 0 : minLength);
