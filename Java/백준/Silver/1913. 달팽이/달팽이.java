/**
* (3, 3) -> (2, 3) -> (2, 4) -> (3, 4) -> (4, 4)
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        
        int[][] snail = new int[N][N];
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        
        int targetR = -1;
        int targetC = -1;
        
        int r = 0, c = 0, d = 0;
        
        int num = N * N;
        
        while (num > 0) {
            snail[r][c] = num;
            
            if (num == target) {
                targetR = r + 1;
                targetC = c + 1;
            }
            
            num --;
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && snail[nr][nc] == 0) {
                r = nr;
                c = nc;
            } else {
                d = (d + 1) % 4;
                r += dr[d];
                c += dc[d];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(snail[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        sb.append(targetR).append(" ").append(targetC);
        System.out.print(sb.toString());
        
    }
}