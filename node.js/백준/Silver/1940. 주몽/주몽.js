const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = ["6", "9", "2 7 4 1 5 3"];

const N = parseInt(input[0]);
const M = parseInt(input[1]);

const numList = input[2].split(" ").map(Number);
numList.sort((a, b) => a - b);

let count = 0;

for (let i = 0; i < N; i++) {
  for (let j = i + 1; j < N; j++) {
    if (numList[i] + numList[j] == M) {
      count++;
    }
  }
}

console.log(count);
