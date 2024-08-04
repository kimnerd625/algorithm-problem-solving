import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        String[][] floor = new String[N][M];
        int[][] isChecked = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().split("");
        }
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (isChecked[r][c] == 0) {
                    isChecked[r][c] = 1;
                    if (floor[r][c].equals("-")) {
                        int nc = c;
                        while ((nc += 1) < M) {
                            if (floor[r][nc].equals("-")) {
                                isChecked[r][nc] = 1;
                            } else {
                                break;
                            }
                        }
                    } else {
                        int nr = r;
                        while ((nr += 1) < N) {
                            if (floor[nr][c].equals("|")) {
                                isChecked[nr][c] = 1;
                            } else {
                                break;
                            }
                        }
                    }
                    answer += 1;
                } 
            }
        }
        
        System.out.println(answer);
    }
}