class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        if (len1 > len2) {
            return 1;
        } else if (len1 < len2) {
            return -1;
        } else {
            int sum1 = 0;
            for (int a1 : arr1) {
                sum1 += a1;
            }
            
            int sum2 = 0;
            for (int a2 : arr2) {
                sum2 += a2;
            }
            
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}