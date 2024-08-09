import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
        	int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int numToken = Integer.parseInt(st.nextToken());
                stack.push(numToken);
            }
            int maxVal = 0;
            long answer = 0L;
            while (!stack.isEmpty()) {
                int tmp = stack.pop();
                if (tmp > maxVal) {
                    maxVal = tmp;
                }
                answer += maxVal - tmp;
            }
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }
}