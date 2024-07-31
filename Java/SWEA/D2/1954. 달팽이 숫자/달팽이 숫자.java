import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
        	int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
            
            int num = 1;
            int x = 0; // x 초기값
            int y = 0; // y 초기값
            int dx = 0, dy = 1; // 초기 방향 설정 (오른쪽)
            while (num <= (N * N)) {
            	snail[x][y] = num++;
                
                // 다음 위치 계산
                int nx = x + dx;
                int ny = y + dy;
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || snail[nx][ny] != 0) {
                	int temp = dx;
                    dx = dy;
                    dy = -temp;
                }
                
                x += dx;
                y += dy;
            }
            
            sb.append("#").append(tc+1).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
	}
}