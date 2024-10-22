const [F, S, G, U, D] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

function BFS(F, S, G, U, D) {
  const queue = [[S, 0]]; // [현재 층, 버튼 누른 횟수]
  const visited = new Set();
  visited.add(S);

  while (queue.length > 0) {
    const [curFloor, btnCnt] = queue.shift();

    if (curFloor === G) {
      return btnCnt; // 목표 층에 도달했을 때 버튼 횟수 반환
    }

    // 위로 올라가기
    if (U > 0 && curFloor + U <= F && !visited.has(curFloor + U)) {
      queue.push([curFloor + U, btnCnt + 1]);
      visited.add(curFloor + U);
    }

    // 아래로 내려가기
    if (D > 0 && curFloor - D >= 1 && !visited.has(curFloor - D)) {
      queue.push([curFloor - D, btnCnt + 1]);
      visited.add(curFloor - D);
    }
  }

  return "use the stairs"; // 목표 층에 도달할 수 없는 경우
}

if (S === G) {
  console.log(0);
} else {
  console.log(BFS(F, S, G, U, D));
}