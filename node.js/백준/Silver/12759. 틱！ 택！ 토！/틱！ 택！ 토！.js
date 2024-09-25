const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

let startP = parseInt(input[0]);
let board = new Array(3).fill().map(() => new Array(3).fill(0));
let count = 1;
let answer = -1;

while (answer == -1 && count <= 9 ) {
    const [r, c] = input[count].split(" ").map(Number);
    board[r-1][c-1] = startP;
    
    if (checkWinner() != -1) {
        answer = checkWinner();
        break;
    }
    
    if (startP == 1) {
        startP = 2;
    } else {
        startP = 1;
    }
    count ++;
}

if (answer == -1) {
    console.log(0);
} else {
    console.log(answer);
}

function checkWinner() {
    for (let i = 0; i < 3; i++) {
        if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return board[i][0];
        }
        if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
            return board[0][i];
        }
    }
    
    if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
        return board[0][0];
    }
    
    if (board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
        return board[2][0];
    }
    
    return -1;
}