import java.io.*;
import java.util.*;

public class Main {
    static int[] firstPrime = {2, 3, 5, 7}; // firstPrime : 한 자리일 때, 소수
    static int n; // n : 입력 받는 N자리 수
    static ArrayList<Integer> magicPrime = new ArrayList<>(); // magicPrime : 신기한 소수를 담을 동적 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 한 자리 소수들로 시작해서 DFS 탐색 시작
        for (int prime : firstPrime) { // 2, 3, 5, 7 반복하며 DFS 시작
            dfs(prime, 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int prime : magicPrime) { // 동적 배열에 있는 각 요소들
            sb.append(prime).append("\n"); // 꺼내서 sb에 담고
        }
        System.out.print(sb.toString()); // sb 출력
    }

    static void dfs(int num, int length) {
        if (length == n) { // 종료 조건 : length가 n과 일치하게 되었을 때
            magicPrime.add(num); // magicPrime 배열에 해당 숫자 추가
            return; // 재귀 종료
        }

        // 1, 3, 5, 7, 9만 반복
        for (int i = 1; i <= 9; i += 2) {
            int nextNum = num * 10 + i; // 해당 숫자 뒤에 추가
            if (isPrime(nextNum)) { // 만약 그렇게 한 숫자가 소수라면
                dfs(nextNum, length + 1); // 해당 숫자 가지고 다음 단계로 넘어가기
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false; // 1이면 (숫자가 2보다 작으면), 소수가 아님
        for (int i = 2; i <= Math.sqrt(num); i++) { // 해당 숫자의 제곱근까지 나눠보면서
            if (num % i == 0) { // 한 번이라도 나눠 떨어지면,
                return false; // 소수가 아님
            }
        }
        return true; // 모든 조건을 거쳐 소수로 판별
    }
}
