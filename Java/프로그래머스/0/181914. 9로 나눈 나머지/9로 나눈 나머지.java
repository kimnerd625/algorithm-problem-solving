class Solution {
    public int solution(String number) {
        int sum = 0;
        char[] arr = number.toCharArray();
        
        for (char a : arr) {
            sum += a - '0';
        }
        
        return sum % 9;
    }
}