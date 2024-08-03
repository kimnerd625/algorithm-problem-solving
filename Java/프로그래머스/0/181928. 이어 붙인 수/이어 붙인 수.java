import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        StringBuilder oddSum = new StringBuilder();
        StringBuilder evenSum = new StringBuilder();
        
        for (int n : num_list) {
            if (n % 2 == 0) {
                evenSum.append(n);
            } else {
                oddSum.append(n);
            }
        }
        
        return Integer.parseInt(oddSum.toString()) + Integer.parseInt(evenSum.toString());
    }
}