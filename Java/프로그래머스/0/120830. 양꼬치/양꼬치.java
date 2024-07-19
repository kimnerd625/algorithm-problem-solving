class Solution {
    public int solution(int n, int k) {
        int m = n / 10;
        return 12000 * n + (k - m) * 2000;
    }
}