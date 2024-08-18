import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();  // 가로 길이
        int H = sc.nextInt();  // 세로 길이
        
        int C = sc.nextInt();  // 상점의 개수
        
        int[][] arr = new int[C][2];
        
        // 상점 위치 입력 받기
        for (int c = 0; c < C; c++) {
            arr[c][0] = sc.nextInt();
            arr[c][1] = sc.nextInt();
        }
        
        // 동근이 위치 입력 받기
        int sDir = sc.nextInt();
        int sP = sc.nextInt();
        
        int answer = 0;
        
        // 상점마다 거리를 계산
        for (int i = 0; i < C; i++) {
            if (sDir == arr[i][0]) {
                answer += Math.abs(arr[i][1] - sP);
            } else if (sDir == 1) {
                if (arr[i][0] == 2) {
                    answer += (H + Math.min((sP + arr[i][1]), ((W-sP) + (W-arr[i][1])))); 
                } else if (arr[i][0] == 3) {
                    answer += (sP + arr[i][1]);
                } else if (arr[i][0] == 4) {
                    answer += ((W-sP) + arr[i][1]);
                }
            } else if (sDir == 2) {
                if (arr[i][0] == 1) {
                    answer += (H + Math.min((sP + arr[i][1]), ((W-sP) + (W-arr[i][1])))); 
                } else if (arr[i][0] == 3) {
                    answer += (sP + (H - arr[i][1]));
                } else if (arr[i][0] == 4) {
                    answer += ((W-sP) + (H - arr[i][1]));
                }
            } else if (sDir == 3) {
                if (arr[i][0] == 1) {
                    answer += sP + arr[i][1];
                } else if (arr[i][0] == 2) {
                    answer += (H-sP) + arr[i][1];
                } else if (arr[i][0] == 4) {
                    answer += (W + Math.min((sP + arr[i][1]), ((H-sP) + (H-arr[i][1]))));
                }
            } else if (sDir == 4) {
                if (arr[i][0] == 1) {
                    answer += sP + (W - arr[i][1]);
                } else if (arr[i][0] == 2) {
                    answer += (H-sP) + (W - arr[i][1]);
                } else if (arr[i][0] == 3) {
                    answer += (W + Math.min((sP + arr[i][1]), ((H-sP) + (H-arr[i][1]))));
                }
            }
        }
        
        System.out.println(answer);
    }
}