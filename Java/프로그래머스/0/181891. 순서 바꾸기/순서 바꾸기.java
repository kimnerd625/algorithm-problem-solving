import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> arrList = new ArrayList<Integer>();
        
        for (int i = n; i < num_list.length; i++) {
            arrList.add(num_list[i]);
        }
        
        for (int i = 0; i < n; i++) {
            arrList.add(num_list[i]);
        }
        
        int[] answer = new int[num_list.length];
        
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = arrList.get(i);
        }
        
        return answer;
    }
}