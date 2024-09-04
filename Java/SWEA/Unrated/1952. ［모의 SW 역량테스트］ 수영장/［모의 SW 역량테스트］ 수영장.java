import java.io.*;

class Solution {
    static StringBuilder sb;

    static int year;
    static int mon3;
    static int mon1;
    static int day;

    static int minCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");

            year = Integer.parseInt(str[3]);
            mon3 = Integer.parseInt(str[2]);
            mon1 = Integer.parseInt(str[1]);
            day = Integer.parseInt(str[0]);

            String[] str2 = br.readLine().split(" ");
            int[] cal = new int[12];

            for (int i = 0; i < 12; i++) {
                cal[i] = Integer.parseInt(str2[i]);
            }

            minCost = year;
            DFS(cal, 0, 0);

            sb.append("#").append(t + 1).append(" ").append(minCost).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void DFS(int[] cal, int cost, int month) {
        if (cost >= minCost) {
            // 이미 현재 비용이 최소 비용보다 크면 탐색 종료
            return;
        }

        if (month >= 12) {
            minCost = Math.min(minCost, cost);
            return;
        }

        if (cal[month] == 0) {
            DFS(cal, cost, month + 1);
            return;
        }

        // 1일 이용권으로 계산
        DFS(cal, cost + cal[month] * day, month + 1);

        // 1개월 이용권으로 계산
        DFS(cal, cost + mon1, month + 1);

        // 3개월 이용권으로 계산 (3개월 사용 가능한 경우 포함)
        if (month < 12) {
            DFS(cal, cost + mon3, month + 3);
        }
    }
}