import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 0; t < 10; t++) {
            int N = Integer.parseInt(br.readLine());
            char[] exp = br.readLine().toCharArray();
            
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            
            for (char c : exp) {
                if (c >= '0' && c <= '9') {
                    sb.append(c);
                } else if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // '(' 제거
                } else {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '+')) {
                        if ((stack.peek() == '*' && c == '+') || (stack.peek() == '+' && c == '+') || (stack.peek() == '*' && c == '*')) {
                            sb.append(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.push(c);
                }
            }
            
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            
            int result = evaluatePostfix(sb.toString());
            System.out.println("#" + (t+1) + " " + result);
        }
    }
    
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        
        for (char c : postfix.toCharArray()) {
            if (c >= '0' && c <= '9') {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if (c == '+') {
                    stack.push(a + b);
                } else if (c == '*') {
                    stack.push(a * b);
                }
            }
        }
        return stack.pop();
    }
}