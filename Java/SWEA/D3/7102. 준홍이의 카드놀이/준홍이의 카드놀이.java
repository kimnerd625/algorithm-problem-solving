import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N+M+1];
            
            for (int n = 1; n <= N; n++) {
            	for (int m = 1; m <= M; m++) {
                	arr[n+m] ++;
                }
            }
            
            int maxVal = 0;
            Queue<Integer> q = new LinkedList<Integer>();
            
            for (int i = 2; i < arr.length; i++) {
            	if (maxVal < arr[i]) {
                    maxVal = arr[i];
                    while (!q.isEmpty()) {
                    	q.poll();
                    }
                    q.add(i);
				} else if (maxVal == arr[i]) {
                	q.add(i);
                }
            }
            
            sb.append("#").append(t+1).append(" ");
            while (!q.isEmpty()) {
            	sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}