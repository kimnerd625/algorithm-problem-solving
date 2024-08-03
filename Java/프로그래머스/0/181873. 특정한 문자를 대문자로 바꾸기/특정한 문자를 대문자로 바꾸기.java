import java.util.*;

class Solution {
    public String solution(String my_string, String alp) {
        char[] charArr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (char c : charArr) {
            if (String.valueOf(c).equalsIgnoreCase(alp)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}