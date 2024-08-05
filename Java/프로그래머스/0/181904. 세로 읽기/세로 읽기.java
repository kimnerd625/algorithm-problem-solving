import java.io.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = my_string.toCharArray();
        
        for (int i = c-1; i < charArr.length; i += m) {
            sb.append(charArr[i]);
        }
        
        return sb.toString();
    }
}