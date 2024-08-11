import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[5][5];
        
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                board[r][c] = sc.nextInt();
            }
        }
        
        boolean isBingo = false;
        int bingoCount = 0;
        int idx = 0;
        
        for (int i = 0; i < 25; i++) {
            if (bingoCount >= 3) {
                idx = i;
                break;
            }
            
            bingoCount = 0;
            
            int temp = sc.nextInt();
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (temp == board[r][c]) {
                        board[r][c] = -1;
                    }
                }
            }
            
            // 가로 검사
            for (int r = 0; r < 5; r++) {
                int check = 0;
                for (int c = 0; c < 5; c++) {
                    if (board[r][c] == -1) {
                        check ++;
                    }
                }
                if (check == 5) {
                    isBingo = true;
                    bingoCount ++;
                }
            }
            
            // 세로 검사
            for (int c = 0; c < 5; c++) {
                int check = 0;
                for (int r = 0; r < 5; r++) {
                    if (board[r][c] == -1) {
                        check ++;
                    }
                }
                if (check == 5) {
                    isBingo = true;
                    bingoCount ++;

                }
            }
            
            // 대각선 검사
            int checkD = 0;
            for (int r = 0; r < 5; r++) {
                if (board[r][r] == -1) checkD ++;
            }
            if (checkD == 5) {
                isBingo = true;
                bingoCount ++;
            }
            
            // 역대각선 검사
            int checkRD = 0;
            for (int r = 0; r < 5; r++) {
                if (board[r][4-r] == -1) checkRD ++;
            }
            if (checkRD == 5) {
                isBingo = true;
                bingoCount ++;
            }
        }
        System.out.println(idx);
        
    }  
}