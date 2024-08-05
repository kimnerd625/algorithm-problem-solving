function solution(s) {
    let answer = 0;
    for (let i = 0; i < s.length; i++) {
        let newStr = s.substring(i) + s.substring(0, i);
        let stack = [];
        let isCorrect = true;
        for (let c of newStr) {
            if (c == "(" || c == "{" || c == "[") {
                stack.push(c);
            } else if (c == ")") {
                if (stack.length == 0 || stack.pop() != "(") {
                    isCorrect = false;
                    break;
                }
            } else if (c == "}") {
                if (stack.length == 0 || stack.pop() != "{") {
                    isCorrect = false;
                    break;
                }
            } else if (c == "]") {
                if (stack.length == 0 || stack.pop() != "[") {
                    isCorrect = false;
                    break;
                }
            }
        }
        if (isCorrect && stack.length === 0) {
            answer += 1;
        }
    }
    return answer;
}