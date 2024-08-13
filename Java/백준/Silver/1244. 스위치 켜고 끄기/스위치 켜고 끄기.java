import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextInt();
        }
        int S = sc.nextInt();
        for (int i = 0; i < S; i++) {
            int gender = sc.nextInt();
            int btn = sc.nextInt();
            if (gender == 1) {
                for (int idx = btn - 1; idx < N; idx += btn) {
                    if (map[idx] == 0) {
                        map[idx] = 1;
                    } else {
                        map[idx] = 0;
                    }
                }
            } else {
                boolean isChangeable = true;
                if (map[btn-1] == 1) {
                    map[btn-1] = 0;
                } else {
                    map[btn-1] = 1;
                }
                int idx = btn-1;
                int plus = 1;
                while (isChangeable) {
                    if (idx+plus >= N || idx-plus < 0) {
                        isChangeable = false;
                        break;
                    } else {
                        if (map[idx+plus] != map[idx-plus]) {
                            isChangeable = false;
                            break;
                        } else {
                            if (map[idx+plus] == 1) {
                                map[idx+plus] = 0;
                                map[idx-plus] = 0;
                            } else {
                                map[idx+plus] = 1;
                                map[idx-plus] = 1;
                            }
                            plus ++;
                        }
                    }
                }
            }
        }
        for (int a = 0; a < N; a++) {
            System.out.print(map[a] + " ");
            if ((a + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}