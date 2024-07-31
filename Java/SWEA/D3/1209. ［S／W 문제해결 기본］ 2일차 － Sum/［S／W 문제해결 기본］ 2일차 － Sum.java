import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 Reader
        StringBuilder sb = new StringBuilder(); // 출력값 Builder
        
        // 테스트 케이스 10회 만큼 반복
        for (int i = 0; i < 10; i++) {
        	int N = Integer.parseInt(br.readLine()); // N: 테스트 케이스 번호
            int map[][] = new int[100][100]; // map: 100 * 100 길이의 2차원 배열
            
            // StringTokenizer 활용 : 이중반복을 통해, 각 요소 int로 변환하여 넣기
            for (int n = 0; n < 100; n++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for (int m =0; m < 100; m++) {
                	map[n][m] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 가로 합의 최댓값 구하기
            int maxVal = 0;
            for (int n = 0; n < 100; n++) {
                int sum = Arrays.stream(map[n]).sum();
                if (maxVal < sum) {
                	maxVal = sum;
                }
            }
            
            // 세로 합의 최댓값 구하기
            for (int m = 0; m < 100; m++) {
                int sum = 0;
            	for (int n = 0; n < 100; n++) {
                	sum += map[n][m];
                }
                if (maxVal < sum) {
                	maxVal = sum;
                }
            }
            
            // 대각선 합의 최댓값 구하기
            int diagSum = 0;
            for (int n = 0; n < 100; n++) {
                diagSum += map[n][n];
            }
            if (maxVal < diagSum) {
            	maxVal = diagSum;
            }
            
            // 역대각선 합의 최댓값 구하기
            int reverseDiagSum = 0;
            for (int n = 0; n < 100; n++) {
            	reverseDiagSum += map[n][100-n-1];
            }
            if (maxVal < reverseDiagSum) {
            	maxVal = reverseDiagSum;
            }
            
            sb.append(String.format("#%s %s\n"
, N, maxVal));
        }
        System.out.println(sb);
	}
}