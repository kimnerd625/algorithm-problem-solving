import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			int totalD = 0;
			int tempD = 0;
			for (int i = 0; i < N; i++) {
				int control = sc.nextInt();
				if (control == 1) {
					tempD += sc.nextInt();
				} else if (control == 2) {
					tempD -= sc.nextInt();
					if(tempD < 0) {
						tempD = 0;
					}
				}
				totalD += tempD;
			}
			
			System.out.println("#" + (t+1) + " " + totalD);
		}
	}
}
