import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            
            char[][] flag = new char[N][M];
            for (int i = 0; i < N; i++) {
                flag[i] = br.readLine().toCharArray();
            }
            
            int minPaint = Integer.MAX_VALUE;
            
            // 흰색 줄의 끝을 i로 설정
            for (int i = 0; i < N - 2; i++) {
                // 파란색 줄의 끝을 j로 설정
                for (int j = i + 1; j < N - 1; j++) {
                    int paintCount = 0;
                    
                    // 흰색 줄 부분 계산
                    for (int x = 0; x <= i; x++) {
                        for (int y = 0; y < M; y++) {
                            if (flag[x][y] != 'W') paintCount++;
                        }
                    }
                    
                    // 파란색 줄 부분 계산
                    for (int x = i + 1; x <= j; x++) {
                        for (int y = 0; y < M; y++) {
                            if (flag[x][y] != 'B') paintCount++;
                        }
                    }
                    
                    // 빨간색 줄 부분 계산
                    for (int x = j + 1; x < N; x++) {
                        for (int y = 0; y < M; y++) {
                            if (flag[x][y] != 'R') paintCount++;
                        }
                    }
                    
                    // 최소 색칠 횟수 갱신
                    minPaint = Math.min(minPaint, paintCount);
                }
            }
            
            sb.append("#").append(t).append(" ").append(minPaint).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}