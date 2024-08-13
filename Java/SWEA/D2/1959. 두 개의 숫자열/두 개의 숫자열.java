import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			int answer = Integer.MIN_VALUE;
			
			if (N >= M) {
				for (int i = 0; i <= N - M; i++) {
					int val = 0;
					for (int j = 0; j < M; j++) {
						val += (A[i + j] * B[j]);
					}
					if (answer < val) answer = val;
				}
			} else {
				for (int i = 0; i <= M - N; i++) {
					int val = 0;
					for (int j = 0; j < N; j++) {
						val += (A[j] * B[i + j]);
					}
					if (answer < val) answer = val;
				}
			}
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
}
