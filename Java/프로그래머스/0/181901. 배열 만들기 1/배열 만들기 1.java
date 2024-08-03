import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> arr = new ArrayList<Integer>();
        
        for (int i = k; i < n+1; i++) {
            if (i % k == 0) {
                arr.add(i);
            }    
        }
        
        int[] answer = new int[arr.size()];
        
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}