import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			sb.append("#").append(t+1).append("\n");
			
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == j) {
						board[i][j] = 1;
					} else if (j == 0) {
						board[i][j] = 1;
					} else {
						board[i][j] = board[i - 1][j - 1] + board[i - 1][j];
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
