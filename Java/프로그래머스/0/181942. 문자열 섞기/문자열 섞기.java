import java.io.*;

class Solution {
    public String solution(String str1, String str2) {
        
        StringBuilder sb = new StringBuilder();
        
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        
        for (int i = 0; i < ch1.length; i++) {
            sb.append(ch1[i]);
            sb.append(ch2[i]);
        }
        
        return sb.toString();
    }
}