class Solution {
    public int solution(int a, int d, boolean[] included) {
        int sum = 0;
        int c = 0;
        
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                sum += a + (d * c);
            }
            c ++;
        }
        
        return sum;
    }
}