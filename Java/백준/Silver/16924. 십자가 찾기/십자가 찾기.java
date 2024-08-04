import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        
        String[][] map = new String[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }
        
        List<int[]> crosses = new ArrayList<int[]>();
        boolean[][] visited = new boolean[N][M];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c].equals("*")) {
                    int size = 0;
                    while (true) {
                        size++;
                        if (r - size < 0 || r + size >= N || c - size < 0 || c + size >= M) {
                            size --;
                            break;
                        }
                        if (!map[r-size][c].equals("*") || !map[r+size][c].equals("*") || !map[r][c-size].equals("*") || !map[r][c + size].equals("*")) {
                            size --;
                            break;
                        }
                    }
                    
                    if (size > 0) {
                        crosses.add(new int[]{r + 1, c + 1, size});
                        visited[r][c] = true;
                        for (int i = 1; i <= size; i++) {
                            visited[r-i][c] = true;
                            visited[r+i][c] = true;
                            visited[r][c-i] = true;
                            visited[r][c+i] = true;
                        }
                    }
                }
            }
        }
        
        boolean valid = true;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c].equals("*") && !visited[r][c]) {
                    valid = false;
                    break;
                }
            }
            if (!valid) break;
        }
        
        if (valid) {
            System.out.println(crosses.size());
            for (int[] cross : crosses) {
                System.out.println(cross[0] + " " + cross[1] + " " + cross[2]);
            }
        } else {
            System.out.println(-1);
        }
    }
}