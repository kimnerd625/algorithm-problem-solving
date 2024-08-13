import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			int P = Integer.parseInt(line[0]);
			int Q = Integer.parseInt(line[1]);
			int R = Integer.parseInt(line[2]);
			int S = Integer.parseInt(line[3]);
			int W = Integer.parseInt(line[4]);
			
			int priceA = P * W;
			int priceB = 0;
			if (R <= W) {
				priceB = Q + (W - R) * S;
			} else {
				priceB = Q;
			}
			
			
			sb.append("#").append(t+1).append(" ").append(Math.min(priceA, priceB)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
