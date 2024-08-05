class Solution {
    public String solution(String myString) {
        char[] arr = myString.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        for (char a : arr) {
            if (a >= 'a' && a <= 'k') {
                sb.append('l');
            } else {
                sb.append(a);
            }
        }
        
        return sb.toString();
    }
}