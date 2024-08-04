import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> arr = new ArrayList<String>();
        
        // 접미사는 문자열의 길이만큼 생겨날 수 있음
        for (int i = 0; i < my_string.length(); i++) {
            arr.add(my_string.substring(i, my_string.length()));
        }
        
        Collections.sort(arr);
        
        String[] answer = arr.toArray(new String[0]);
        
        return answer;
    }
}