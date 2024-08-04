import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        
        String[][] map = new String[N][N];
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].equals("M")) {
                    // 오른쪽
                    if (c + 4 < N && map[r][c+1].equals("O") && map[r][c+2].equals("B") && map[r][c+3].equals("I") && map[r][c+4].equals("S")) {
                        answer++;
                    }
                    // 왼쪽
                    if (c - 4 >= 0 && map[r][c-1].equals("O") && map[r][c-2].equals("B") && map[r][c-3].equals("I") && map[r][c-4].equals("S")) {
                        answer++;
                    }
                    // 아래
                    if (r + 4 < N && map[r+1][c].equals("O") && map[r+2][c].equals("B") && map[r+3][c].equals("I") && map[r+4][c].equals("S")) {
                        answer++;
                    }
                    // 위
                    if (r - 4 >= 0 && map[r-1][c].equals("O") && map[r-2][c].equals("B") && map[r-3][c].equals("I") && map[r-4][c].equals("S")) {
                        answer++;
                    }
                    // 대각선 오른쪽 아래
                    if (r + 4 < N && c + 4 < N && map[r+1][c+1].equals("O") && map[r+2][c+2].equals("B") && map[r+3][c+3].equals("I") && map[r+4][c+4].equals("S")) {
                        answer++;
                    }
                    // 대각선 왼쪽 위
                    if (r - 4 >= 0 && c - 4 >= 0 && map[r-1][c-1].equals("O") && map[r-2][c-2].equals("B") && map[r-3][c-3].equals("I") && map[r-4][c-4].equals("S")) {
                        answer++;
                    }
                    // 대각선 오른쪽 위
                    if (r - 4 >= 0 && c + 4 < N && map[r-1][c+1].equals("O") && map[r-2][c+2].equals("B") && map[r-3][c+3].equals("I") && map[r-4][c+4].equals("S")) {
                        answer++;
                    }
                    // 대각선 왼쪽 아래
                    if (r + 4 < N && c - 4 >= 0 && map[r+1][c-1].equals("O") && map[r+2][c-2].equals("B") && map[r+3][c-3].equals("I") && map[r+4][c-4].equals("S")) {
                        answer++;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}