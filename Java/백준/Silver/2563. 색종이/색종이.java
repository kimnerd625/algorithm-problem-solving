import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int[][] board = new int[101][101];
        for (int t = 0; t < T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            
            for (int x = X; x < X + 10; x++) {
                for (int y = Y; y < Y + 10; y++) {
                    if (board[y][x] == 0) board[y][x] = 1;
                }
            }
        }
        int answer = 0;
        for (int r = 0; r < 101; r++) {
            for (int c = 0; c < 101; c++) {
                answer += board[r][c];
            }
        }
        
        System.out.println(answer);
    }
}