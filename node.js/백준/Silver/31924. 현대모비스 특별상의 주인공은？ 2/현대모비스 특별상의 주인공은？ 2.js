const fs = require('fs');

// 입력 받는 부분
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = parseInt(input[0]);  // 첫 번째 줄은 N
const grid = input.slice(1);   // 그 이후는 격자판

// 방향 배열 설정: 상, 하, 좌, 우, 대각선 4방향
const directions = [
  [-1, 0], [1, 0], [0, -1], [0, 1],    // 상, 하, 좌, 우
  [-1, -1], [-1, 1], [1, -1], [1, 1]   // 대각선 4방향
];

// MOBIS 문자열을 찾는 함수
function findMOBIS(grid, N) {
  const target = "MOBIS";
  let count = 0;

  // 그리드 내에서 탐색을 시작하는 함수
  function search(x, y, direction) {
    let str = '';
    for (let i = 0; i < 5; i++) {
      const newX = x + directions[direction][0] * i;
      const newY = y + directions[direction][1] * i;

      // 그리드 경계 체크
      if (newX < 0 || newX >= N || newY < 0 || newY >= N) return false;
      str += grid[newX][newY];
    }
    return str === target;
  }

  // 모든 위치에서 8방향으로 탐색
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      for (let dir = 0; dir < 8; dir++) {
        if (search(i, j, dir)) {
          count++;
        }
      }
    }
  }

  return count;
}

// 결과 출력
console.log(findMOBIS(grid, N));