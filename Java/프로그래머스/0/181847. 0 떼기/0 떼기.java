import java.util.*;

class Solution {
    public String solution(String n_str) {
        StringBuilder sb = new StringBuilder();
        
        char[] arr = n_str.toCharArray();
        boolean isFirst = true;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0' && isFirst == true) {
                if (arr[i+1] != '0') {
                    isFirst = false;
                }
            } else {
                if (i == 0) {
                    isFirst = false;
                }
                sb.append(arr[i]);
            }
        }
        
        return sb.toString();
    }
}