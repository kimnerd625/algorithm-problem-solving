const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

const [N, ...sList] = input;

let tmpHigh = 0;
let count = 0;

while (sList.length != 0) {
  let tmp = sList.pop();
  if (tmp > tmpHigh) {
    tmpHigh = tmp;
    count++;
  }
}

console.log(count);
