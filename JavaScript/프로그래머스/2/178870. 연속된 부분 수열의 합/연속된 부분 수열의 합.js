function solution(sequence, k) {
    let answer = [];
    let left = 0;
    let right = 0;
    let sum = sequence[0];
    
    let minLen = Infinity;

    while (left <= right && right < sequence.length) {
        if (sum === k) {
            let len = right - left;
            if (len < minLen) {
                minLen = len;
                answer = [left, right];
            }
            sum -= sequence[left];
            left++;
        } else if (sum < k) {
            right++;
            sum += sequence[right];
        } else {
            sum -= sequence[left];
            left++;
        }
    }
    
    return answer;
}
