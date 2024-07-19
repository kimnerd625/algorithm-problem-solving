import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int n = num2 - num1 + 1;
        int[] arr = new int[n];
        int c = 0;
        
        for (int i = num1; i < num2 + 1; i++) {
            arr[c++] = numbers[i];
        }
        
        return arr;
    }
}