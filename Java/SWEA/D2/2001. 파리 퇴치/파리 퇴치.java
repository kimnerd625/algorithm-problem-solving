import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값을 받기 위한 Reader
     	StringBuilder sb = new StringBuilder(); // 출력을 위한 Builder
        
        int T = Integer.parseInt(br.readLine()); // T : 테스트 케이스
        // 테스크 케이스, T만큼 반복
        for (int tc = 0; tc < T; tc++) {
            // StringTokenizer 활용, 한 줄의 입력값 받기
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 각각 N
            int M = Integer.parseInt(st.nextToken()); // M에 입력 받은 정수값 할당
            
            // map : N * N 2차원 배열
            int map[][] = new int[N][N];
            
            // 반복문 통해, 각 행렬에 입력 받은 정수값 할당
            for (int n = 0; n < N; n++) {
            	st = new StringTokenizer(br.readLine());
                for (int m = 0; m < N; m++) {
                	map[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            // M * M의 범위가 map의 범위를 벗어나지 않을 만큼 반복
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j ++) {
                    int flyNums = 0;
                    for (int dy = 0; dy < M; dy++) {
                        for (int dx = 0; dx < M; dx++) {
                            flyNums += map[i+dy][j+dx];
                        }                
                	}
					if (answer < flyNums) answer = flyNums;
                }
            }
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
	}
}