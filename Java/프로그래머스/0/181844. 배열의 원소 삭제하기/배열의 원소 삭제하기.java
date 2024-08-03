import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> editedList = new ArrayList<Integer>();
        for (int a : arr) {
            editedList.add(a);
        }
        
        for (int del : delete_list) {
            if (editedList.indexOf(del) != -1) {
                editedList.remove(editedList.indexOf(del));
            }
        }
        
        int[] answer = new int[editedList.size()];
        
        for (int i = 0; i < editedList.size(); i++) {
            answer[i] = editedList.get(i);
        }
        
        return answer;
    }
}