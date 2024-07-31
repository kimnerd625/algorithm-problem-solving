import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 10번 반복
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int N = Integer.parseInt(br.readLine()); // N : 테스트 케이스 번호
			int map[][] = new int[100][100]; // map:  100 * 100의 2차원 배열
            
            // StringTokenizer 통해, 2차원 배열에 정수로 변환한 값 할당
            for (int n = 0; n < 100; n++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for (int m = 0; m < 100; m++) {
                	map[n][m] = Integer.parseInt(st.nextToken());
                }
            }
            
            int x = 0; // 초기 x 좌표 (2의 x 위치)
            int y = 99; // 초기 y 좌표 (맨 아래 행) (2의 y위치)
            
            // 맨 밑에 행의 2 위치 찾기
            for (int i = 0; i < 100; i++) {
            	if (map[y][i] == 2) {
                	x = i;
                    break;
                }
            }
            
            // 사다리를 타고 올라가며 역추적
            while (y > 0) {
               // 왼쪽으로 이동
                if (x > 0 && map[y][x - 1] == 1) {
                    while (x > 0 && map[y][x - 1] == 1) {
                        x--;
                    }
                }
                // 오른쪽으로 이동
                else if (x < 99 && map[y][x + 1] == 1) {
                    while (x < 99 && map[y][x + 1] == 1) {
                        x++;
                    }
                }
                // 위로 이동
                y--;
            }
            
            sb.append("#").append(N).append(" ").append(x).append("\n");
		}
        
        System.out.println(sb);
	}
}