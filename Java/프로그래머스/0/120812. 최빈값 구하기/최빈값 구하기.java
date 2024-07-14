class Solution {
    public int solution(int[] array) {
        // 빈도수를 저장할 배열
        int [] frequency = new int[1000];
        
        // 배열의 각 요소의 빈도 계산
        for (int num : array) {
            frequency[num]++;
        }
        
        int maxFrequency = 0;
        int mode = -1;
        boolean multipleModes = false;
        
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                mode = i;
                multipleModes = false;
                
            } else if (frequency[i] == maxFrequency) {
                multipleModes = true;
            }
        }
        
        if (multipleModes) {
            return -1;
        }
        
        return mode;
    }
}