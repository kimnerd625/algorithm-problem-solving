import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int[][] board = new int[1001][1001];
        
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int width = Integer.parseInt(line[2]);
            int height = Integer.parseInt(line[3]);
            
            int x2 = x1 + width;
            int y2 = y1 + height;
            
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    board[y][x] = t;  // 색종이의 번호로 덮어쓰기
                }
            }
        }
        
        int[] answer = new int[T + 1];
        
        // 전체 board를 확인하며 각 색종이의 면적을 계산
        for (int r = 0; r < 1001; r++) {
            for (int c = 0; c < 1001; c++) {
                if (board[r][c] != 0) {  // 0이 아닌 경우 (색종이가 놓인 경우)
                    answer[board[r][c]]++;
                }
            }
        }
        
        for (int i = 1; i <= T; i++) {
            System.out.println(answer[i]);
        }
    }
}