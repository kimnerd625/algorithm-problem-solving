import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
    	int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < 10; t++) {
        	int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();
            while (st.hasMoreTokens()) {
            	arr.add(Integer.parseInt(st.nextToken()));
            }
            sb.append("#").append(t+1).append(" ");
            Collections.sort(arr);
            for (int a : arr) {
            	sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}