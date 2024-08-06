import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> arr = new ArrayList<Integer>();
        
        for (String a : intStrs) {
            int temp = Integer.parseInt(a.substring(s, s+l));
            if (temp > k) {
                arr.add(temp);
            }
        }
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}