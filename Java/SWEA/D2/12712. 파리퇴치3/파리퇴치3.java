import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int answer = Integer.MIN_VALUE;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int start = map[r][c];
					int tmpVal = start;
					
					for (int dr = -M + 1; dr < M; dr++) {
						if (dr == 0) {
							continue;
						}
						int nr = r + dr;
						if (nr >= 0 && nr < N) {
							tmpVal += map[nr][c];
						}
					}
					
					for (int dc = -M + 1; dc < M; dc++) {
						if (dc == 0) {
							continue;
						}
						int nc = c + dc;
						if (nc >= 0 && nc < N) {
							tmpVal += map[r][nc];
						}
					}
					
					if (answer < tmpVal) answer = tmpVal;
					
					
					tmpVal = start;
					
					for (int dm = -M + 1; dm < M; dm++) {
						if (dm == 0) {
							continue;
						}
						int nr = r + dm;
						int nc = c + dm;
						
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							tmpVal += map[nr][nc];
						};
						
						int rc = c - dm;
						if (nr >= 0 && nr < N && rc >= 0 && rc < N) {
							tmpVal += map[nr][rc];
						}
					}
					if (answer < tmpVal) answer = tmpVal;
				}
			}
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
}
