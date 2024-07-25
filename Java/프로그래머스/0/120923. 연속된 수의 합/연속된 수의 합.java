class Solution {
    public int[] solution(int num, int total) {
        int a = total / num;
        int b = num / 2;
        int[] answer = new int[num];
        
        for (int i = 0; i < num; i++) {
            if (num % 2 == 0) {
                answer[i] = a + i - b + 1;
            } else {
                answer[i] = a + i - b;       
            }
        }
        
        return answer;
    }
}