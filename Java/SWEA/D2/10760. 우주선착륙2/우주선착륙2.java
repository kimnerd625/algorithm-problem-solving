import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int[] dr = {-1, 0, 1, -1, 1, -1, 0, 1};
			int[] dc = {-1, -1, -1, 0, 0, 1, 1, 1};
			
			int dir = 0;
			int answer = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int cNum = map[r][c];
					int cCount = 0;
					for (int i = 0; i < 8; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if (nr >= 0 && nc >= 00 && nr < N && nc < M && map[nr][nc] < cNum) {
							cCount ++;
						}
					}
					if (cCount >= 4) {
						answer ++;
					}
				}
			}
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
}
