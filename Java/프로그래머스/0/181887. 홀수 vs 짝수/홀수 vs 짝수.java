class Solution {
    public int solution(int[] num_list) {
        int idx = 1;
        
        int oddSum = 0;
        int evenSum = 0;
        
        for (int n : num_list) {
            if (idx % 2 == 0) {
                evenSum += n;
            } else {
                oddSum += n;
            }
            idx++;
        }
        
        return Math.max(oddSum, evenSum);
    }
}