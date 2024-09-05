import java.io.*;
import java.util.*;

public class Main {
    static int N; // 컴퓨터의 수
    static int M; // 네트워크 연결 수
    static int count; // 감염된 컴퓨터의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 네트워크 연결 수

        // 각 컴퓨터와 연결된 다른 컴퓨터들을 저장하는 리스트
        ArrayList<Integer>[] arrayOfLists = new ArrayList[N + 1]; // 1번 컴퓨터부터 N번 컴퓨터

        for (int i = 1; i <= N; i++) {
            arrayOfLists[i] = new ArrayList<>();
        }

        // 네트워크 연결 정보를 입력받아 인접 리스트를 구성
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");

            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            arrayOfLists[x].add(y); // x 컴퓨터에 y 컴퓨터 연결
            arrayOfLists[y].add(x); // y 컴퓨터에 x 컴퓨터 연결 (양방향 연결)
        }

        // 감염된 컴퓨터 수 초기화
        count = 0;
        boolean[] visited = new boolean[N + 1]; // 방문 여부를 확인하는 배열

        // 1번 컴퓨터에서 시작하여 바이러스 전파
        dfs(1, visited, arrayOfLists);

        // 출력 (1번 컴퓨터 제외, 감염된 컴퓨터의 수)
        System.out.println(count - 1);
    }

    static void dfs(int x, boolean[] visited, ArrayList<Integer>[] arrayOfLists) {
        visited[x] = true; // 현재 컴퓨터를 방문 처리
        count++; // 감염된 컴퓨터 수 증가

        // 연결된 컴퓨터들을 하나씩 확인
        for (int i : arrayOfLists[x]) {
            if (!visited[i]) { // 아직 방문하지 않은 컴퓨터라면
                dfs(i, visited, arrayOfLists); // 그 컴퓨터를 탐색
            }
        }
    }
}
