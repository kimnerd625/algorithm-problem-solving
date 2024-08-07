import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> tempList = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                tempList.add(i);
            }
        }
        
        int [] answer = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }
        
        return answer;
    }
}