import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] left = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] top = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] garden = new int[N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
            garden[i][0] = left[i-1];
        }
        
        for (int j = 1; j <= M; j++) {
            garden[0][j] = top[j-1];
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                garden[i][j] = (garden[i-1][j] == garden[i][j-1]) ? 0 : 1;
            }
        }
        
        System.out.println(garden[N][M]);
        
    }
}