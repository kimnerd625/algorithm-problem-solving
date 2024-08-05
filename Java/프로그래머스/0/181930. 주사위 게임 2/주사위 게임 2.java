class Solution {
    public int solution(int a, int b, int c) {
        if (a != b && b != c && c != a) {
            return a + b + c;
        }
        
        if ((a == b && c != a) || (a == c && b != a) || (b == c && a != b)) {
            return (a + b + c) * (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        }
        
        return (a + b + c) * (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (int)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
    }
}