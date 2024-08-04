import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[3][3];
        int firstPlayer = Integer.parseInt(br.readLine());
        int secondPlayer;
        if (firstPlayer == 2) {
            secondPlayer = 1;
        } else {
            secondPlayer = 2;
        }
        boolean isFirstTurn = true;
        
        String temp;
        while ((temp = br.readLine()) != null) {
            String[] axis = temp.split(" ");
            int r = Integer.parseInt(axis[0]);
            int c = Integer.parseInt(axis[1]);
            
            if (isFirstTurn) {
                board[r-1][c-1] = firstPlayer;
                if (checkWin(board, firstPlayer)) {
                    System.out.println(firstPlayer);
                    return;
                }
            } else {
                board[r-1][c-1] = secondPlayer;
                if (checkWin(board, secondPlayer)) {
                    System.out.println(secondPlayer);
                    return;
                }
            }
            isFirstTurn = !isFirstTurn;
        }
        
        System.out.println(0);
    }
    private static boolean checkWin(int[][] board, int player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||(board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        
        return false;
    } 
}