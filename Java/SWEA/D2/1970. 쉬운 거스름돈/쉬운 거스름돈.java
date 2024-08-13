import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			sb.append("#").append(t+1).append("\n");
			
			int res = 0;
			sb.append(N / 50000).append(" ");
			res = N % 50000;
			sb.append(res / 10000).append(" ");
			res = N % 10000;
			sb.append(res / 5000).append(" ");
			res = N % 5000;
			sb.append(res / 1000).append(" ");
			res = N % 1000;
			sb.append(res / 500).append(" ");
			res = N % 500;
			sb.append(res / 100).append(" ");
			res = N % 100;
			sb.append(res / 50).append(" ");
			res = N % 50;
			sb.append(res / 10).append("\n");
			res = N % 10;
		}
		
		System.out.println(sb.toString());
	}
}
