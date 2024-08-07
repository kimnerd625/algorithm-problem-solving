import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            Queue<Integer> q = new LinkedList<Integer>();
            int tc = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            
            while (st.hasMoreTokens()) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            
            int minus = 1;
            while (true) {
                int tmp = q.poll();
                tmp -= minus;
                if (tmp <= 0) {
                    tmp = 0;
                    q.add(tmp);
                    break;
                } else {
                    q.add(tmp);
                }
                minus++;
                if (minus > 5) minus = 1;
            }
            
            sb.append("#").append(tc).append(" ");
            while (!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}