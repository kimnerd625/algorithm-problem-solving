import java.io.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(my_string.substring(0, s));
        
        sb.append(new StringBuilder(my_string.substring(s, e+1)).reverse());
        
        sb.append(my_string.substring(e+1, my_string.length()));
        
        return sb.toString();
    }
}