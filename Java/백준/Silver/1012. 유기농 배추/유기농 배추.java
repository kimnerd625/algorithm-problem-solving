import java.io.*;

public class Main {
    static int count;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]); // 열의 수
            N = Integer.parseInt(str[1]); // 행의 수
            int K = Integer.parseInt(str[2]);

            int[][] graph = new int[N][M];
            boolean[][] visited = new boolean[N][M]; // 방문 여부를 확인하는 배열

            for (int i = 0; i < K; i++) {
                String[] str2 = br.readLine().split(" ");
                int c = Integer.parseInt(str2[0]); // 열의 인덱스
                int r = Integer.parseInt(str2[1]); // 행의 인덱스

                graph[r][c] = 1; // 배추가 심어져 있는 위치 표시
            }

            count = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (graph[r][c] == 1 && !visited[r][c]) { // 배추가 있고 아직 방문하지 않은 경우
                        count++;
                        DFS(graph, visited, r, c); // 새로운 군집을 찾았으므로 DFS 탐색 시작
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void DFS(int[][] graph, boolean[][] visited, int r, int c) {
        visited[r][c] = true; // 현재 위치 방문 처리

        int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            // 그래프 경계를 벗어나지 않고, 아직 방문하지 않은 배추가 있는 경우
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && graph[nx][ny] == 1) {
                DFS(graph, visited, nx, ny);
            }
        }
    }
}