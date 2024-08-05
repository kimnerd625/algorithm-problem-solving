class Solution {
    public int solution(int[][] board, int k) {
        int sum = 0;
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[0].length; c++) {
                if (r + c <= k) {
                    sum += board[r][c];
                }
            }
        }
        return sum;
    }
}