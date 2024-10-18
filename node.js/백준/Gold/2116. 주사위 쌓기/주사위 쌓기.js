/**
 * 주사위 쌓기
 *
 * 일단 위, 아래에 사용하는 주사위 면은 최대한 작을 수록 좋다.
 *
 * 그렇지만 또, 그 다음 주사위의 윗면과 일치하게 만들 수 있어야 한다.
 *
 * 1-6, 2-4, 3-5 -> 0-5, 1-3, 2-4
 *
 */

const input = require("fs")
 .readFileSync("/dev/stdin")
 .toString()
 .trim()
 .split("\n");

const diceCnt = parseInt(input[0]);
const dices = Array(diceCnt);
let answer = 0;

for (let i = 1; i <= diceCnt; i++) {
  const [a, b, c, d, e, f] = input[i].split(" ").map(Number);
  const dc = [];
  dc.push([b, d, Math.max(a, c, e, f)]);
  dc.push([d, b, Math.max(a, c, e, f)]);
  dc.push([a, f, Math.max(b, c, d, e)]);
  dc.push([f, a, Math.max(b, c, d, e)]);
  dc.push([c, e, Math.max(a, b, d, f)]);
  dc.push([e, c, Math.max(a, b, d, f)]);
  dices[i - 1] = dc;
}

for (let l of dices[0]) {
  addNum(1, l[1], l[2]);
}

console.log(answer);

function addNum(level, top, sum) {
  if (level == diceCnt) {
    answer = Math.max(answer, sum);
    return;
  }

  const list = dices[level];
  for (let l of list) {
    if (l[0] == top) {
      addNum(level + 1, l[1], sum + l[2]);
    }
  }
}
