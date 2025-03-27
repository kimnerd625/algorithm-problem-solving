function solution(begin, target, words) {
    if (!words.includes(target)) return 0;
    
    const visited = new Set();
    const queue = [[begin, 0]];
    
    while (queue.length) {
        const [current, step] = queue.shift();
        
        if (current == target) return step;
        
        for (const word of words) {
            if (!visited.has(word)) {
                let diffCount = 0;
                let isDiffOne = true;
                for (let i = 0; i < current.length; i++) {
                    if (current[i] != word[i]) diffCount++;
                    if (diffCount > 1) {
                        isDiffOne = false;
                        break;
                    }
                }
                if (isDiffOne) {
                    visited.add(word);
                    queue.push([word, step + 1]);
                }
            }
        }
    }
    return 0;
}