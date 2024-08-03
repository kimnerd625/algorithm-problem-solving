import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] arr = my_string.toCharArray();
        
        int count = 0;
        for (char c : arr) {
            if (count == n) {
                break;
            }
            sb.append(c);
            count ++;
        }
        
        return sb.toString();
    }
}