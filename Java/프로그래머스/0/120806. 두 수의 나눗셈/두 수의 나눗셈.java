class Solution {
    public int solution(int num1, int num2) {
        // 정수형끼리 나누면, 소수 부분은 버려지는데,
        // 소수점을 버리면 안 되므로, double로 형변환을 한다.
        // 정수 부분을 다시 출력해야 하므로, int로 형변환을 한 번 더 한다.
        double answer = (double) num1 / num2 * 1000;
        return (int) answer;
    }
}