function solution(rectangle, characterX, characterY, itemX, itemY) {
    const SIZE = 102;  // 좌표를 2배로 늘릴 것이므로 (1~50) * 2 = 100 보다 큰 값
    const map = Array.from(Array(SIZE), () => Array(SIZE).fill(0));

    // 1. 좌표를 2배로 확장
    rectangle = rectangle.map(([x1, y1, x2, y2]) => 
        [x1 * 2, y1 * 2, x2 * 2, y2 * 2]
    );

    // 2. 테두리를 맵에 기록
    rectangle.forEach(([x1, y1, x2, y2]) => {
        for (let x = x1; x <= x2; x++) {
            for (let y = y1; y <= y2; y++) {
                if (x === x1 || x === x2 || y === y1 || y === y2) {
                    if (map[x][y] === 0) map[x][y] = 1;  // 테두리 표시
                } else {
                    map[x][y] = 2;  // 내부는 2로 표시해서 지나갈 수 없게 함
                }
            }
        }
    });

    // 3. BFS로 최단거리 탐색
    const queue = [[characterX * 2, characterY * 2, 0]];
    const visited = Array.from(Array(SIZE), () => Array(SIZE).fill(false));
    visited[characterX * 2][characterY * 2] = true;

    const dx = [1, -1, 0, 0];
    const dy = [0, 0, 1, -1];

    while (queue.length) {
        const [x, y, dist] = queue.shift();

        if (x === itemX * 2 && y === itemY * 2) {
            return dist / 2;  // 다시 2배 했던 거 되돌리기
        }

        for (let i = 0; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];

            if (map[nx][ny] === 1 && !visited[nx][ny]) {  // 테두리만 이동 가능
                visited[nx][ny] = true;
                queue.push([nx, ny, dist + 1]);
            }
        }
    }
}
