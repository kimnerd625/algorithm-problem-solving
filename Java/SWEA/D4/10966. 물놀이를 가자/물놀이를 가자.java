import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int M;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);

            char[][] board = new char[N][M];
            boolean[][] visited = new boolean[N][M];
            Queue<int[]> q = new LinkedList<>();

            for (int r = 0; r < N; r++) {
                char[] str2 = br.readLine().toCharArray();
                for (int c = 0; c < M; c++) {
                    board[r][c] = str2[c];
                    if (board[r][c] == 'W') {
                        q.offer(new int[]{r, c}); // 모든 'W'를 큐에 추가
                        visited[r][c] = true; // 'W'는 방문 표시
                    }
                }
            }

            answer = 0;
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            // BFS 시작: 모든 'W'에서 동시에 탐색 시작
            while (!q.isEmpty()) {
                int[] current = q.poll();
                int x = current[0];
                int y = current[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                        if (board[nx][ny] == 'L') {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                            board[nx][ny] = (char) (board[x][y] + 1); // 최소 거리 계산
                            answer += (board[nx][ny] - 'W'); // 총 이동 횟수에 추가
                        }
                    }
                }
            }

            System.out.print("#" + (t + 1) + " " + answer + "\n");
        }
    }
}