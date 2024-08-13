import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int cut = N/10;
			
			sb.append("#").append(t+1).append(" ");
			
			HashMap<Integer, Double> map = new HashMap<Integer, Double>();
			for (int i = 0; i < N; i++) {
				double point = 0.35 * sc.nextInt() + 0.45 * sc.nextInt() + 0.2 * sc.nextInt();
				map.put(i+1, point);
			}
			
			List<Integer> keySet = new ArrayList<>(map.keySet());
			
			keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
			
			int place = keySet.indexOf(K);
			int where = place / cut;
			switch (where) {
			case 0:
				sb.append("A+");
				break;
			case 1: 
				sb.append("A0");
				break;
			case 2:
				sb.append("A-");
				break;
			case 3:
				sb.append("B+");
				break;
			case 4:
				sb.append("B0");
				break;
			case 5:
				sb.append("B-");
				break;
			case 6:
				sb.append("C+");
				break;
			case 7:
				sb.append("C0");
				break;
			case 8:
				sb.append("C-");
				break;
			default:
				sb.append("D0");
				break;
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
