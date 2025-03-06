

function solution(numbers, target) {
    
    let arr = new Array(numbers.length * 2);
    for (let i = 0, n = 1; n < arr.length; i++, n+=2) {
        arr[n] = numbers[i];
    }
    console.log(arr)
    let num = numbers.length;
    let answer = 0;
    
    function DFS(L) {
        if (L == num) {
            if (eval(arr.join("")) == target) answer ++;
        } else {
            arr[L * 2] = "+";
            DFS(L+1);
            arr[L * 2] = "-";
            DFS(L+1);
        }
    } 
    
    DFS(0)
    
    return answer;
}