import java.util.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        
        for (int[] temp : parts) {
            int s = temp[0];
            int e = temp[1];
            
            sb.append(my_strings[i++].substring(s, e+1));
        }
        
        return sb.toString();
    }
}