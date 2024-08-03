import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        
        List<String> arr = new ArrayList<String>();
        
        while (st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        
        return arr.toArray(new String[0]);
    }
}