const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

let [N, K, T] = input[0].split(" ").map(Number);
let sea = input[1].split(" ").map(Number);

sea.sort((a, b) => a - b);

let food = [];

for (s of sea) {
  if (T > s) {
    food.push(s);
  } else {
    while (food.length > 0) {
      if (K > 0) {
        let temp = food.pop();
        if (temp !== undefined) {
          T += temp;
        }
        K--;
      } else {
        break;
      }
      if (T > s) {
        food.push(s);
        break;
      }
    }
  }
}

if (K > 0) {
  while (K > 0) {
    K--;
    let temp = food.pop();
    if (temp !== undefined) {
      T += temp;
    }
  }
}

console.log(T);
