import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[2][6];
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            
            board[gender][grade-1] += 1;
            if (board[gender][grade-1] == K) {
                answer += 1;
                board[gender][grade-1] = 0;
            }
        }
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] >= 1) {
                    answer += 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}