import java.io.*;
import java.util.*;

public class Solution {
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            int[][] board = new int[N + 1][N + 1]; // 배열 크기를 N+1로 수정
            boolean[] visited = new boolean[N + 1]; // 1차원 방문 배열 사용
            for (int i = 0; i < M; i++) {
                String[] str2 = br.readLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);

                board[a][b] = board[b][a] = 1; // 1-based 인덱스로 수정
            }

            count = 0; // 덩어리 개수 초기화

            // 모든 사람을 순회하며 연결된 구성 요소 탐색
            for (int i = 1; i <= N; i++) { // 사람 번호는 1부터 N까지
                if (!visited[i]) { // 아직 방문하지 않은 사람에 대해
                    count++;
                    bfs(board, visited, i); // BFS 시작
                }
            }

            sb.append("#").append(t + 1).append(" ").append(count).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void bfs(int[][] board, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 1; i < board.length; i++) { // 모든 사람을 검사
                if (board[current][i] == 1 && !visited[i]) { // 연결되어 있고 방문하지 않은 경우
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}