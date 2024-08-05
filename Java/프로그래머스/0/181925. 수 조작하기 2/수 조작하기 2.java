import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        for (int n : numLog) {
            if (n - tmp == 1) {
                sb.append("w");
            } else if (n - tmp == -1) {
                sb.append("s");
            } else if (n - tmp == 10) {
                sb.append("d");
            } else if (n - tmp == -10) {
                sb.append("a");
            }
            tmp = n;
        }
        
        return sb.toString();
    }
}