import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String [] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 0; t < 10; t++) {
            StringBuilder result = new StringBuilder();
            Stack<Character> stack = new Stack<>();
        	int len = Integer.parseInt(br.readLine());
            char[] formular = br.readLine().toCharArray();
            
            for (char c : formular) {
            	if ('0' <= c && '9' >= c) {
                	result.append(c);
                } else if (c == '+') {
                	while (!stack.isEmpty() && stack.peek() == '+') {
                    	result.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
            
            while (!stack.isEmpty()) {
            	result.append(stack.pop());
            }
            
            Stack<Integer> answer = new Stack<>();
            
            for (char c : result.toString().toCharArray()) {
            	if (Character.isDigit(c)) {
                	answer.push(c - '0');
                } else if (c == '+') {
                	int b = answer.pop();
                    int a = answer.pop();
                    answer.push(a + b);
                }
            }
            int ans = answer.pop();
            System.out.println("#" + (t+1) + " " + ans);
        }
    }
}