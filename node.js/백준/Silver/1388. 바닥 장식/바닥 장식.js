const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

let [N, M] = input[0].split(" ").map(Number);
let board = [];
for (let n = 1; n <= N; n++) {
    board.push(input[n].split(""));
}

let hCount = 0;
for (let i = 0; i < N; i++) {
    let prev = "";
    for (let j = 0; j < M; j++) {
        if (board[i][j] == "-") {
            if (prev !== "-") {
                hCount ++;
            }
        }
        prev = board[i][j];
    }
}

let vCount = 0;
for (let j = 0; j < M; j++) {
    let prev = "";
    for (let i = 0; i < N; i++) {
        if (board[i][j] == '|') {
            if (prev != '|') {
                vCount ++;
            }
        }
        prev = board[i][j];
    }
}

let tCount = hCount + vCount;
console.log(tCount);