const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

// 0을 뽑으면, 그대로
// 1을 뽑으면, 하나 앞으로
// 2를 뽑으면, 둘 앞으로
// 다시 말해, 뽑는 숫자는 스택에서 얼마나 뽑아낸 다음에 내가 들어갈 것인지를 말하는 것임

// const input = ["5", "0 1 1 3 2"];

const S = parseInt(input[0]);
let list = input[1].split(" ").map(Number);

let stack = [];
let student = 1;

for (let i = 0; i < list.length; i++) {
  let temp = list[i];
  let tempQ = [];
  while (temp != 0) {
    tempQ.push(stack.pop());
    temp--;
  }
  stack.push(student);
  while (tempQ.length != 0) {
    stack.push(tempQ.pop());
  }
  student++;
}

console.log(stack.join(" "));
