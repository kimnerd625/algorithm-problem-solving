import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] iLine = br.readLine().split(" ");
        N = Integer.parseInt(iLine[0]);
        M = Integer.parseInt(iLine[1]);
        int[] start = {0, 0};

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = BFS(board, new boolean[N][M], start);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static ArrayDeque<Integer[]> q = new ArrayDeque<>();

    static int BFS(int[][] board, boolean[][] qIn, int[] cur) {
        q.offer(new Integer[]{cur[0], cur[1]});
        qIn[cur[0]][cur[1]] = true;
        int[][] distance = new int[N][M];
        distance[cur[0]][cur[1]] = 1;

        while (!q.isEmpty()) {
            Integer[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !qIn[nx][ny] && board[nx][ny] != 0) {
                    q.offer(new Integer[]{nx, ny});
                    qIn[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;

                    if (nx == N - 1 && ny == M - 1) {
                        return distance[nx][ny];
                    }
                }
            }
        }

        return -1;
    }
}