import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
        	char[] line = br.readLine().toCharArray();
            Queue<Integer> q = new LinkedList<>();
            for (char c : line) {
            	q.add(c - '0');
            }
            
            int compare = 0;
            int count = 0;
            
            while (!q.isEmpty()) {
            	int temp = q.poll();
                if (compare != temp) {
                	compare = temp;
                    count ++;
                }
            }
            
            sb.append("#").append(t+1).append(" ").append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}