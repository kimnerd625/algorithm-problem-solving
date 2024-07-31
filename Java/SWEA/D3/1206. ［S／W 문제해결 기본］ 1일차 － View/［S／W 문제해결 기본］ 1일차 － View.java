import java.util.*;

class Solution
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            int answer = 0;
            for (int k = 2; k < N - 2; k++) {
                int maxNeighborHeight = Math.max(Math.max(arr[k-2], arr[k-1]), Math.max(arr[k+1], arr[k+2]));
                if (arr[k] > maxNeighborHeight) {
                    answer += arr[k] - maxNeighborHeight;
                }
            }
            System.out.println("#" + (i + 1) + " " + answer);
        }
        sc.close();
    }
}