import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringBuilder sb = new StringBuilder(); // 출력
        
        // 10회의 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int N = Integer.parseInt(br.readLine()); // N: 테스트 케이스
            int[][] map = new int[100][100]; // maps : 100 * 100 2차원 배열
            
            // StringTokenizer 활용하여, 2차원 배열에 정수 값 할당
            for (int n = 0; n < 100; n++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for (int m = 0; m < 100; m++) {
                	map[n][m] = Integer.parseInt(st.nextToken());
                }
            }
                      
            int minLength = Integer.MAX_VALUE;
            int answer = 0;
            for (int x = 0; x < 100; x++) {
                int y = 0;
            	if (map[y][x] == 1) {
                    int tempX = x;
                    int length = 0;
                    while (y < 99) {
                    	if (x > 0 && map[y][x-1] == 1) {
                        	while (x > 0 && map[y][x-1] == 1) {
                            	x --;
                                length ++;
                            }
                        } else if (x < 99 && map[y][x+1] == 1) {
                        	while (x < 99 && map[y][x+1] == 1) {
                            x ++;
                            length ++;
                            }
                        }
                        y ++;
                        length ++;
                    }
                    if (minLength > length) {
                    	minLength = length;
                        answer = tempX;
                    }
                    // x를 원래 값으로 복원
                    x = tempX;
                }
            }
            
            sb.append("#").append(N).append(" ").append(answer).append("\n");
		}
        System.out.println(sb);
	}
}