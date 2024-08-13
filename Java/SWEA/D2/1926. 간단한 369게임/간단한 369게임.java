import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			char[] tempList = (i + "").toCharArray();
			boolean isClap = false;
			StringBuilder tempSb = new StringBuilder();
			for (char c : tempList) {
				if (c == '3' || c == '6' || c =='9') {
					sb.append("-");
					isClap = true;
				} else if (isClap == false){
					tempSb.append(c);
				}
			}
			if (!isClap) {
				sb.append(tempSb.toString());
			}
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
