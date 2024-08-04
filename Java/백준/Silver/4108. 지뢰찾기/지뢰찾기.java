import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String temp;
        while (!(temp = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(temp);
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            String[][] map = new String[R][C];
            
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().split("");
            }
            
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c].equals("*")) {
                        continue;
                    }
                    int count = 0;
                    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
                    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
                    
                    for (int i = 0; i < 8; i++) {
                        int ny = r + dy[i];
                        int nx = c + dx[i];
                        if (nx >= 0 && ny >= 0 && ny < R && nx < C) {
                            if (map[ny][nx].equals("*")) {
                                count ++;
                            }
                        }
                    }
                    
                    map[r][c] = String.valueOf(count);
                }
            }
            
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    System.out.print(map[r][c]);
                }
                System.out.println();
            }
        }

    }
}