class Solution {
    public int solution(int[] common) {
        boolean isGongcha = false;
        
        if (common[2] - common[1] == common[1] - common[0]) {
            isGongcha = true;
        }
        
        if (isGongcha) {
            return common[common.length - 1] + common[1] - common[0];
        } else {
            return common[common.length - 1] * (common[1] / common[0]);
        }
    }
}