import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        List<String> answerArr = new ArrayList<String>();
        
        while (st.hasMoreTokens()) {
            answerArr.add(st.nextToken());
        }
        
        return answerArr.toArray(new String[0]);
    }
}