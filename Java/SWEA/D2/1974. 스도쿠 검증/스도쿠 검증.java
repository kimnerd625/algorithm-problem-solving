import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int[][] board = new int[9][9];
            
            for (int r = 0; r < 9; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 9; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            
            boolean isSudoku = true;
            
            // Check rows
            for (int r = 0; r < 9; r++) {
                if (!isSudoku) break;
                boolean[] checked = new boolean[9];
                for (int c = 0; c < 9; c++) {
                    if (checked[board[r][c] - 1]) {
                        isSudoku = false;
                        break;
                    }
                    checked[board[r][c] - 1] = true;
                }
            }
            
            // Check columns
            for (int c = 0; c < 9; c++) {
                if (!isSudoku) break;
                boolean[] checked = new boolean[9];
                for (int r = 0; r < 9; r++) {
                    if (checked[board[r][c] - 1]) {
                        isSudoku = false;
                        break;
                    }
                    checked[board[r][c] - 1] = true;
                }
            }
            
            // Check 3x3 subgrids
            for (int row = 0; row < 9; row += 3) {
                for (int col = 0; col < 9; col += 3) {
                    if (!isSudoku) break;
                    boolean[] checked = new boolean[9];
                    for (int r = row; r < row + 3; r++) {
                        for (int c = col; c < col + 3; c++) {
                            if (checked[board[r][c] - 1]) {
                                isSudoku = false;
                                break;
                            }
                            checked[board[r][c] - 1] = true;
                        }
                        if (!isSudoku) break;
                    }
                }
                if (!isSudoku) break;
            }
            
            if (isSudoku) {
                sb.append("#").append(t + 1).append(" 1\n");
            } else {
                sb.append("#").append(t + 1).append(" 0\n");
            }
        }
        System.out.print(sb.toString());
    }
}