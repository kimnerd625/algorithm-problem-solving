import java.util.*;

class Solution {
    public int solution(int order) {
        int answer = 0;
        String orderStr = order + "";
        List<Integer> arr = new ArrayList<Integer>();
        
        for (int i = 0; i < orderStr.length(); i++) {
            arr.add(Character.getNumericValue(orderStr.charAt(i)));
        }
        
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 3 || arr.get(i) == 6 || arr.get(i) == 9) {
                answer ++;
            }
        }
        return answer;
    }
}