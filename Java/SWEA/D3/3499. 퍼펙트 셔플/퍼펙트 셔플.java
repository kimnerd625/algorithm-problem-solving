
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbAnswer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int halfN = (N+1) / 2;
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			
			for (int i = 0; i < halfN; i++) {
				q1.add(st.nextToken());
			}
			
			for (int i = halfN; i < N; i++) {
				q2.add(st.nextToken());
			}
			
			while (!(q1.isEmpty() && q2.isEmpty())) {
				if (!q1.isEmpty()) {
					sb.append(q1.poll() + " ");
				}
				
				if (!q2.isEmpty()) {
					sb.append(q2.poll() + " ");
				}
			}
			sbAnswer.append("#").append(t+1).append(" ").append(sb.toString().trim()).append("\n");
		}
		
		System.out.print(sbAnswer.toString());
	}

}
