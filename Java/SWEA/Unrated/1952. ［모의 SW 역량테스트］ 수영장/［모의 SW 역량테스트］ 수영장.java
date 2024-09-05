import java.io.*;

public class Solution {

	static int year;
	static int mon3;
	static int mon1;
	static int day;
	
	static int minCost;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] str = br.readLine().split(" ");
			
			year = Integer.parseInt(str[3]);
			mon3 = Integer.parseInt(str[2]);
			mon1 = Integer.parseInt(str[1]);
			day = Integer.parseInt(str[0]);
			
			int[] cal = new int[12];
			String[] str2 = br.readLine().split(" ");
			for (int i = 0; i < 12; i++) {
				cal[i] = Integer.parseInt(str2[i]);
			}
			
			minCost = year; // minCost - 연간 비용 할당
			
			DFS(cal, 0, 0);
			
			sb.append("#").append(t+1).append(" ").append(minCost).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void DFS(int[] cal, int month, int cost) {
		// 이미 현 비용이 최소 비용보다 작을 때,
		if (cost > minCost) {
			return;
		}
		
		// 12개월 이상이 되었을 때, 
		if (month >= 12) {
			minCost = Math.min(cost, minCost);
			return;
		}
		
		// 이번 달에는 하루도 수업을 안 갈 계획일 때,
		if (cal[month] == 0) {
			DFS(cal, month + 1, cost);
		}
		
		// 이번 달에는 일일권으로 모두 계산할 때,
		DFS(cal, month + 1, cost + cal[month] * day);
		
		// 이번 달에는 1달권으로 계산할 때,
		DFS(cal, month + 1, cost + mon1);
		
		// 이번 달에는 3달권으로 계산할 때,
		if (month < 12) {
			DFS(cal, month + 3, cost + mon3);
		}
	}

}
