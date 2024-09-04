import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] cheese = new int[N][N];
            int maxCheeseValue = 0; // 치즈의 최대 값

            // 치즈 정보를 입력받고 최대 맛있는 정도를 계산합니다.
            for (int r = 0; r < N; r++) {
                String[] line = br.readLine().split(" ");
                for (int c = 0; c < N; c++) {
                    cheese[r][c] = Integer.parseInt(line[c]);
                    maxCheeseValue = Math.max(maxCheeseValue, cheese[r][c]); // 치즈의 최대 값 업데이트
                }
            }

            int maxVal = 1; // 최대 덩어리 개수를 저장하는 변수입니다.

            // 0일째 치즈 덩어리 개수를 계산합니다.
            maxVal = Math.max(maxVal, countCheeseChunks(cheese, N, 0));

            // 1일부터 치즈의 최대 값까지 치즈가 먹히는 날을 시뮬레이션합니다.
            for (int day = 1; day <= maxCheeseValue; day++) {
                maxVal = Math.max(maxVal, countCheeseChunks(cheese, N, day));
            }

            sb.append("#").append(t + 1).append(" ").append(maxVal).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 주어진 날에 치즈가 먹힌 후 남은 덩어리 개수를 계산합니다.
    static int countCheeseChunks(int[][] cheese, int N, int day) {
        boolean[][] isEaten = new boolean[N][N]; // 치즈가 먹혔는지 여부를 저장하는 배열
        boolean[][] visited = new boolean[N][N]; // BFS 탐색 중 방문 여부를 저장하는 배열
        int cheeseCnt = 0; // 치즈 덩어리 개수를 세는 변수

        // 현재 날짜에 해당하는 치즈를 먹음
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (cheese[r][c] <= day) { // 현재 날짜에 해당하는 치즈는 먹힙니다.
                    isEaten[r][c] = true;
                }
            }
        }

        // BFS로 치즈 덩어리 개수를 탐색합니다.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!isEaten[r][c] && !visited[r][c]) { // 먹히지 않고 방문하지 않은 치즈 덩어리
                    bfs(cheese, isEaten, visited, new int[]{r, c});
                    cheeseCnt++; // 덩어리 개수를 증가시킵니다.
                }
            }
        }

        return cheeseCnt;
    }

    // BFS 탐색 함수
    static void bfs(int[][] cheese, boolean[][] isEaten, boolean[][] visited, int[] cur) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(cur);
        visited[cur[0]][cur[1]] = true;

        int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
        int[] dy = {-1, 1, 0, 0};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < cheese.length && ny >= 0 && ny < cheese.length 
                    && !isEaten[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}