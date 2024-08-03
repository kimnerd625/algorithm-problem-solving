import java.util.*;

class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : myString.toCharArray()) {
            if (c == 'a') {
                sb.append(Character.toUpperCase(c));
            } else if (c == 'A') {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        return sb.toString();
    }
}