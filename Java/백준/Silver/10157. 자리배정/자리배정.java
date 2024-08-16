import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dx = {1, 0, -1, 0};  // 오른쪽, 위, 왼쪽, 아래로 이동할 때 x 좌표의 변화량
        int[] dy = {0, 1, 0, -1};  // 오른쪽, 위, 왼쪽, 아래로 이동할 때 y 좌표의 변화량

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();  // 세로 줄의 수
        int C = sc.nextInt();  // 가로 줄의 수
        int K = sc.nextInt();  // 찾고자 하는 대기번호

        int[][] arr = new int[R][C];  // 공연장 좌석 배열

        // 만약 대기번호 K가 전체 좌석 수보다 크면 자리 배정이 불가능하므로 0 출력
        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int y = 0;  // 현재 좌석의 y 좌표 (열)
        int x = 0;  // 현재 좌석의 x 좌표 (행)
        int num = 1;  // 현재 대기번호
        int dir = 0;  // 현재 이동 방향

        while (true) {
            arr[y][x] = num;  // 현재 좌석에 대기번호를 배정
            
            if (num == K) {  // K번째 대기번호에 도달했으면, 그 좌석의 위치를 출력하고 종료
                System.out.println((y + 1) + " " + (x + 1));  // y와 x는 0부터 시작하므로 1을 더해 1부터 시작하도록 함
                return;
            }
            
            int nx = x + dx[dir];  // 다음 x 좌표
            int ny = y + dy[dir];  // 다음 y 좌표
            
            // 범위를 벗어나거나 이미 채워진 경우, 방향을 전환
            if (ny < 0 || nx < 0 || ny >= R || nx >= C || arr[ny][nx] != 0) {
                dir = (dir + 1) % 4;  // 시계방향으로 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;  // 다음 좌표로 이동
            y = ny;
            num++;  // 대기번호 증가
        }
    }
}