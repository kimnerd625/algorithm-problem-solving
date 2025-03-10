function solution(n, wires) {
    let minDiff = Infinity;

    // 그래프를 인접 리스트로 변환하는 함수
    function buildGraph(wires) {
        const graph = Array.from({ length: n + 1 }, () => []);
        wires.forEach(([v1, v2]) => {
            graph[v1].push(v2);
            graph[v2].push(v1);
        });
        return graph;
    }

    // BFS를 이용한 서브트리 크기 계산
    function bfs(start, removedEdge, graph) {
        let queue = [start];
        let visited = new Array(n + 1).fill(false);
        let count = 1;
        visited[start] = true;

        while (queue.length) {
            let node = queue.shift();
            for (let next of graph[node]) {
                if (!visited[next] && !(node === removedEdge[0] && next === removedEdge[1]) &&
                    !(node === removedEdge[1] && next === removedEdge[0])) {
                    visited[next] = true;
                    queue.push(next);
                    count++;
                }
            }
        }
        return count;
    }

    // 각 전선을 하나씩 제거하며 트리 크기 차이 계산
    for (let [v1, v2] of wires) {
        let graph = buildGraph(wires);
        let size1 = bfs(v1, [v1, v2], graph);  // 첫 번째 서브트리 크기
        let size2 = n - size1;  // 전체 n에서 빼서 두 번째 서브트리 크기
        minDiff = Math.min(minDiff, Math.abs(size1 - size2));
    }

    return minDiff;
}
