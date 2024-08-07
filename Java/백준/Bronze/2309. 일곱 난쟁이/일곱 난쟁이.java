import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        addSum(arr, 7, 0, 0, result);
    }
    
    public static boolean addSum(int[] arr, int n, int sum, int idx, List<Integer> result) {
        if (n == 0) {
            if (sum == 100) {
                printResult(result);
                return true;
            }
            return false;
        } else {
            for (int i = idx; i < arr.length; i++) {
                result.add(arr[i]);
                if (addSum(arr, n - 1, sum + arr[i], i + 1, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
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