import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t= 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
            
            boolean possible = true;
            for (int i =1; i <= N; i++) {
                int aTime = pq.poll();
                int fishBreads = (aTime / M) * K;
                
                if (fishBreads < i) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("#" + (t + 1) + " Possible");
            } else {
                System.out.println("#" + (t + 1) + " Impossible");
            }
        }
    }
}