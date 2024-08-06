import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.trim().split("x");
        List<String> answer = new ArrayList<String>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) answer.add(arr[i]);
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
}