class Solution {
    public int[] solution(int money) {
        int a = money / 5500;
        int b = money % 5500;
        return new int[]{a, b};
    }
}