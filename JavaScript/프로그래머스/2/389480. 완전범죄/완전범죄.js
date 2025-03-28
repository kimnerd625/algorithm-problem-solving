/**
  1. m을 최대한 쓰기
  2. n은 최소한으로 쓰기
*/

function solution(info, n, m) {
    info.sort((a, b) => b[1] !== a[1] ? b[1] - a[1] : a[0] - b[0]);
    
    
    const len = info.length;
    const memo = new Map();
    
    const DFS = (i, a, b) => {
        if (a >= n || b >= m) return Infinity;
        if (i === len) return a;
        
        const key = `${i}, ${a}, ${b}`;
        if (memo.has(key)) return memo.get(key);
        
        const [aTrace, bTrace] = info[i];
        
        const useA = DFS(i + 1, a + aTrace, b);
        const useB = DFS(i + 1, a, b + bTrace);
        
        const result = Math.min(useA, useB);
        memo.set(key, result);
        return result;
    }
    
    const answer = DFS(0, 0, 0);
    return answer === Infinity ? - 1 : answer;
}