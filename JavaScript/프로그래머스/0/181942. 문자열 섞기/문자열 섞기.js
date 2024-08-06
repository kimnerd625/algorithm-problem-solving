function solution(str1, str2) {
    let answer = str1.split("").map((el, index) => el + str2[index]);
    
    return answer.join("");
}