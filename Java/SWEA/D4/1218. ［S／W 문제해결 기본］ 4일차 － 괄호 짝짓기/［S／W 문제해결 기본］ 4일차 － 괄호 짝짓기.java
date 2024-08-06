import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            int l = Integer.parseInt(br.readLine());
            char[] inputArr = br.readLine().toCharArray();
            
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (char c : inputArr) {
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        isBalanced = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                } else if (c == '>') {
                    if (stack.isEmpty() || stack.pop() != '<') {
                        isBalanced = false;
                        break;
                    }
                }
            }
            
            if (!stack.isEmpty()) {
                isBalanced = false;
            }
            
            int answer = isBalanced ? 1 : 0;

            // 여기서 sb를 매번 초기화합니다.
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i + 1).append(" ").append(answer);
            System.out.println(sb.toString());
        }
    }
}