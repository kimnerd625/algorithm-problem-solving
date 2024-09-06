import java.io.*;

public class Solution {
    static int N;
    static int K;
    static int maxH;
    static int ans;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[][] mountain;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            K = Integer.parseInt(str[1]);
            maxH = 0;
            ans = 0;

            mountain = new int[N][N];

            for (int r = 0; r < N; r++) {
                String[] str2 = br.readLine().split(" ");
                for (int c = 0; c < N; c++) {
                    mountain[r][c] = Integer.parseInt(str2[c]);
                    if (mountain[r][c] > maxH) {
                        maxH = mountain[r][c];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mountain[i][j] == maxH) {
                        visited = new boolean[N][N];
                        work(i, j, 1, true);
                    }
                }
            }

            System.out.println("#" + (t+1) + " " + ans);
        }
    }

    // r, c : 현재 좌표
    // dist : 지금까지의 공사 길이
    // skill : 공사의 유무, 공사를 할 수 있는가
    private static void work(int r, int c, int dist, boolean skill) {
        if (dist > ans)
            ans = dist;

        visited[r][c] = true; // 방문했고,
                        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] != true) {
                if (mountain[r][c] > mountain[nr][nc]) {
                    work(nr, nc, dist + 1, skill);
                } else if (skill && mountain[r][c] > mountain[nr][nc] - K) {
                    int originalHeight = mountain[nr][nc];
                    mountain[nr][nc] = mountain[r][c] - 1;
                    work(nr, nc, dist + 1, false);
                    mountain[nr][nc] = originalHeight;
                }
            }
        } 

        visited[r][c] = false; // 원상복구
    }
}