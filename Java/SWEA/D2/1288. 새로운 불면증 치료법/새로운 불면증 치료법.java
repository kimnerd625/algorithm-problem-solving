import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] check = new int[10];
			
			int answer = 0;
			
			while (Arrays.stream(check).sum() != 10) {
				answer += N;
				char[] tmp = (answer + "").toCharArray();
				for (char c : tmp) {
					int num = c - '0';
					check[num] = 1;
				}
			}
			System.out.println("#" + (t+1) + " " + answer);
		}

	}
}
