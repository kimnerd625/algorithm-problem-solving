class Solution {
    public int solution(int[] num_list) {
        int totalMul = 1;
        int totalSum = 0;
        
        for (int n : num_list) {
            totalMul *= n;
            totalSum += n;
        }
        
        return totalMul < Math.pow(totalSum, 2) ? 1 : 0;
    }
}