import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            answer.add(arr[i]);
        }
        
        for (int j = intervals[1][0]; j <= intervals[1][1]; j++) {
            answer.add(arr[j]);
        }
        
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}