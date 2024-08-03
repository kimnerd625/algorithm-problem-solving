import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String myString) {
        List<Integer> arr = new ArrayList<Integer>();

        char[] charList = myString.toCharArray();
        
        int tempLength = 0;
        
        for (char c: charList) {
            if (c == 'x') {
                arr.add(tempLength);
                tempLength = 0;
            } else {
                tempLength ++;      
            }
        }
        arr.add(tempLength);
        
        int[] answer = new int[arr.size()];
        
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer; 
    }
}