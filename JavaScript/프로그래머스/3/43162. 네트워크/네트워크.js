/**
1. 첫 배열부터 시작
2. 넘어갈 수 있으면 넘어가고 체크
3. 탐색이 끝나면 answer 1 증가
4. 다른 배열에서도 1이 보이면 다시 시작
*/

function solution(n, computers) {
    let visited = new Array(n).fill(false);
    let answer = 0;
    
    function DFS(i) {
        visited[i] = true;
        for (let j = 0; j < n; j++) {
            if (computers[i][j] === 1 && !visited[j]) {
                DFS(j);
            }
        }
    }
    
    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            DFS(i);
            answer++;
        }
    }
    
    return answer;
}