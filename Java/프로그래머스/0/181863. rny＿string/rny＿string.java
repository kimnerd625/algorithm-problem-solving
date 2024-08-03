import java.util.*;
import java.io.*;

class Solution {
    public String solution(String rny_string) {
        char[] charArr = rny_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (char c : charArr) {
            if (c == 'm') {
                sb.append("rn");
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}