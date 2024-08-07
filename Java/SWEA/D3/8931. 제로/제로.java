import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int answer = 0;
        	int K = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            
            for (int i = 0; i < K; i++) {
            	int temp = Integer.parseInt(br.readLine());
                if (temp != 0) {
                	stack.push(temp);
                } else {
                	stack.pop();
                }
            }
            
            while (!stack.isEmpty()) {
            	answer += stack.pop();
            }
            
            System.out.println("#" + (t+1) + " " + answer);
        }
    }
}