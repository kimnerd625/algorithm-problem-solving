import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> arr = new ArrayList<String>();
        
        for (String s : strArr) {
            if (!s.contains("ad")) {
                arr.add(s);
            }
        }
        
        return arr.toArray(new String[0]);
    }
}