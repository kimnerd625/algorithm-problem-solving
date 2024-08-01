import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int tempSum = numbers[i] + numbers[j];
                
                if (answer.indexOf(tempSum) == -1) {
                    answer.add(tempSum);
                }
            }
        }
        
        answer.sort(null);
        
        int[] intArray = answer.stream().mapToInt(Integer::intValue).toArray();
        
        return intArray;
    }
}