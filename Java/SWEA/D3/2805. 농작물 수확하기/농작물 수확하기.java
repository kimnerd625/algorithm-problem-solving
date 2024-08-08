import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
        	int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];
            for (int r = 0; r < N; r++) {
            	String line = br.readLine().trim();
                for (int c = 0; c < N; c++) {
                	board[r][c] = line.charAt(c) - '0';
                }
            }
            
            int answer = 0;
            int b = N / 2;
            int p = 0;
            for (int r = 0; r < N; r++) {
            	for (int c = b-p; c <= b+p; c++) {
                    answer += board[r][c];
                }
                if (r < b) {
                    p++;
                } else {
                    p--;
                }
            }
            
            sb.append("#").append(t+1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}