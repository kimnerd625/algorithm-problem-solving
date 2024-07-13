// 기약 분수: 분자와 분모를 최대 공약수로 나누면 된다.

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int a = numer1 * denom2 + numer2 * denom1;
        int b = denom1 * denom2;
        
        int max_val = 0;
        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                max_val = i;
                break;
            }
        }
        
        return new int[]{a / max_val, b / max_val};
    }
}