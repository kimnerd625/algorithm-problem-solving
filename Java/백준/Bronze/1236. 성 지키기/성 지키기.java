import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        int rowCount = 0;
        int colCount = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[][] arr = new String[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }
       
        for (int dy = 0; dy < N; dy++) {
            boolean hasGuard = false;
            for (int dx = 0; dx < M; dx++) {
                if (arr[dy][dx].equals("X")) {
                    hasGuard = true;
                    break;
                }
            }
            if (!hasGuard) {
                rowCount ++;
            }
        }
        
        for (int dx = 0; dx < M; dx++) {
            boolean hasGuard = false;
            for (int dy = 0; dy < N; dy++) {
                if(arr[dy][dx].equals("X")) {
                    hasGuard = true;
                   break; 
                }
            }
            if (!hasGuard) {
                colCount ++;   
            }
        }
        
        int answer = Math.max(colCount, rowCount);
        
        System.out.println(answer);
    }
}