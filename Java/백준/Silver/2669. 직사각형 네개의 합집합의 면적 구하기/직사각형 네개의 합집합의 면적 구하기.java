import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] map = new int[101][101];
        
        for (int t = 0; t < 4; t++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);
            
            for (int x = x1; x < x2; x++) {  // x2를 포함하지 않도록 '<' 사용
                for (int y = y1; y < y2; y++) {  // y2를 포함하지 않도록 '<' 사용
                    map[y][x] = 1;
                }
            }
        }
        
        int answer = 0;
        for (int r = 1; r < 101; r++) {
            for (int c = 1; c < 101; c++) {
                answer += map[r][c];
            }
        }
        
        System.out.println(answer);
    }
}