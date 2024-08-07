import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> result = new ArrayList<>();
        addSum(arr, 7, 0, 0, result);
    }
    
    public static boolean addSum(int[] arr, int n, int sum, int idx, List<Integer> result) {
        if (n == 0) {
            if (sum == 100) {
                printResult(result);
                return true; // 결과를 찾으면 재귀 호출 종료
            }
            return false; // n이 0이 되었지만 sum이 100이 아닌 경우
        } else {
            for (int i = idx; i < arr.length; i++) {
                result.add(arr[i]);
                if (addSum(arr, n - 1, sum + arr[i], i + 1, result)) {
                    return true; // 결과를 찾으면 재귀 호출 종료
                }
                result.remove(result.size() - 1); // 정확한 요소 제거
            }
        }
        return false;
    }
    
    public static void printResult(List<Integer> result) {
        Collections.sort(result);
        for (int num : result) {
            System.out.println(num);
        }
    }
}