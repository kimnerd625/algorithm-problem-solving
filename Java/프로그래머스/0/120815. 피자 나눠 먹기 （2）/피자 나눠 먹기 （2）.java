class Solution {
    public int solution(int n) {
        // n과 6의 최소 공배수 구하고 이를 6으로 나는 것이 result
        // 최소 공배수는 n과 6을 곱한 것을 최대 공약수로 나눈 것
        
        // 최대 공약수 구하기
        int gcf = 1;
        for (int i = Math.max(n, 6); i >= 1; i--) {
            if (n % i == 0 && 6 % i == 0) {
                gcf = i;
                break;
            }
        }
        
        // 최소 공배수 구하기
        int lcm = n * 6 / gcf;
        
        // 답 구하기
        return lcm / 6;
    }
}