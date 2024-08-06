import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int checkLength = 2;
        
        while (checkLength < arr.length) {
            checkLength *= 2;
        }
        
        return Arrays.copyOf(arr, checkLength);
    }
}