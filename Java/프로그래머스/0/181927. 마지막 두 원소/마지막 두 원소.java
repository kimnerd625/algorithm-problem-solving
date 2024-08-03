class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        int lastOne = num_list[num_list.length-1];
        int lastTwo = num_list[num_list.length-2];
        
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        
        if (lastOne <= lastTwo) {
            answer[num_list.length] = lastOne * 2;
        } else {
            answer[num_list.length] = lastOne - lastTwo;
        }
        
        return answer;
    }
}