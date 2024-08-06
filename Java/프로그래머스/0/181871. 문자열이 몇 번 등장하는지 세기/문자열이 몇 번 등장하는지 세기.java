import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        List<String> arr = new ArrayList<>();
        
        for (int i = 0; i < myString.length() - pat.length() + 1; i++) {
            arr.add(myString.substring(i, i+pat.length()));
        }
        
        for (String a : arr) {
            if (a.equals(pat)) {
                answer ++;
            }
        }
        
        return answer;
    }
}