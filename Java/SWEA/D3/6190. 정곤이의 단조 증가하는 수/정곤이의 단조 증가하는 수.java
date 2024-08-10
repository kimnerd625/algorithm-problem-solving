import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i< N; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = -1;
            for (int i = 0 ; i < N-1; i++) {
            	for (int j = i+1; j < N; j++) {
                    boolean isNotMonotonic = true;
                	String line = arr[i] * arr[j] + "";
                    char[] cLine = line.toCharArray();
                    char cTemp = '0';
                    for (char c : cLine) {
                    	if (c < cTemp) {
                            isNotMonotonic = false;
                            break;
                        }
                        cTemp = c;
                    }
                    if (isNotMonotonic) {
                    	if (answer < arr[i] * arr[j]) {
                        	answer = arr[i] * arr[j];
                        }
                    }
                }
            }
            
            sb.append("#").append(t+1).append(" ").append(answer).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}