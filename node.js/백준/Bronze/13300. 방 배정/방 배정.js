const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, K] = input[0].split(" ").map(Number);

let divider = Array(12).fill(0);  // 2 * 6 = 12개의 칸으로 성별과 학년을 구분

for (let i = 1; i < input.length; i++) {
  const [sex, grade] = input[i].split(" ").map(Number);
  
  // grade - 1로 학년을 0~5로 맞추고, 성별에 6을 곱해 6 이상의 인덱스를 만듦
  divider[(grade - 1) + sex * 6]++;
}

let roomCnt = 0;

// 나눠진 인원 수에 따라 방 개수 계산
for (let d of divider) {
  roomCnt += Math.ceil(d / K);
}

console.log(roomCnt);