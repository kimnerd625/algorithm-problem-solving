class Solution {
    public int solution(int n, String control) {
        char[] arr = control.toCharArray();
        
        for (char a : arr) {
            if (a == 'w') {
                n ++;
            } else if (a == 's') {
                n --;
            } else if (a == 'd') {
                n += 10;
            } else if (a == 'a') {
                n -= 10;
            }
        }
        return n;
    }
}