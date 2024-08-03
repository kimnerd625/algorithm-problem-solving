import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> answerArr = new ArrayList<String>();
        
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) {
                answerArr.add(strArr[i].toLowerCase());
            } else {
                answerArr.add(strArr[i].toUpperCase());
            }
        }
        
        return answerArr.toArray(new String[0]);
    }
}