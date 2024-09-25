const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

const N = parseInt(input[0]);

let count = 0;

for (let i = 1; i <= N; i++) {
    let tmp = input[i].split("");
    let stack = [];
    
    for (let j = 0; j < tmp.length; j++) {
	    let b = tmp[j];
	    if (stack.length != 0) {
        let a = stack.pop();
        if (a != b) {
          stack.push(a);
          stack.push(b);
        }
      } else {
        stack.push(b);
      }
    }
    if (stack.length == 0) {
        count ++;
    }
}

console.log(count);