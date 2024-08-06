import java.io.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = my_string.toCharArray();
        
        for (int i : indices) {
            charArr[i] = '\0';
        }
        
        for (char c : charArr) {
            if (c != '\0') {
                sb.append(c);
            }
        }
        
        return sb.toString();
        
    }
}