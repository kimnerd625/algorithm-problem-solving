import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String rotated = rotateLeft(s, i);
            if (isCorrect(rotated.toCharArray())) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public String rotateLeft(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
    
    // 올바른 괄호 유무 판단 함수
    public boolean isCorrect (char[] str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (char a : str) {
            if (a == '(' || a =='{' || a == '[') {
                stack.push(a);
            } else {
                if (a == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                } else if (a == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                } else if (a == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}