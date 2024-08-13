import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			
			for (int r = 0; r < N; r++) {
				List<Integer> tempList = new ArrayList<>();
				int count = 0;
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {
						count ++;
					} else {
						tempList.add(count);
						count = 0;
					}
				}
                if (count != 0) {
					tempList.add(count);
				}
				for (int i = 0; i < tempList.size(); i++) {
					if (tempList.get(i) == K) {
						answer ++;
					}
				}
			}
			
			for (int c = 0; c < N; c++) {
				List<Integer> tempList = new ArrayList<>();
				int count = 0;
				for (int r = 0; r < N; r++) {
					if (map[r][c] == 1) {
						count ++;
					} else {
						tempList.add(count);
						count = 0;
					}
				}
                if (count != 0) {
					tempList.add(count);
				}
				for (int i = 0; i < tempList.size(); i++) {
					if (tempList.get(i) == K) {
						answer ++;
					}
				}
			}
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}

}
