import java.util.*;

class Solution {
    public String solution(int age) {
        String[] arr = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        ArrayList<String> answer = new ArrayList<>();
        
        String numToStr = age+"";
        for (int i = 0; i < numToStr.length(); i++) {
            int index = Character.getNumericValue(numToStr.charAt(i));
            answer.add(arr[index]);
        }
        
        StringBuilder result = new StringBuilder();
        for (String s : answer) {
            result.append(s);
        }
        
        return result.toString();
    }
}