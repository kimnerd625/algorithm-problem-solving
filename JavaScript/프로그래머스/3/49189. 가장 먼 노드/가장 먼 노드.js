function solution(n, edge) {
    const board = Array.from({ length: n + 1 }, () => []);
    const visited = Array(n + 1).fill(false);
    const distance = Array(n + 1).fill(0);

    for (const [a, b] of edge) {
        board[a].push(b);
        board[b].push(a);
    }

    const q = [1];
    visited[1] = true;

    while (q.length) {
        const current = q.shift();

        for (const neighbor of board[current]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                distance[neighbor] = distance[current] + 1;
                q.push(neighbor);
            }
        }
    }

    const maxDist = Math.max(...distance);
    return distance.filter(d => d === maxDist).length;
}
