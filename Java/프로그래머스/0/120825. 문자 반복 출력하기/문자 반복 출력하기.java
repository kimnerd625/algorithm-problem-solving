class Solution {
    public String solution(String my_string, int n) {
        StringBuilder a = new StringBuilder();
        
        for (char e: my_string.toCharArray()) {
            for (int i = 0; i < n; i++) {
                a.append(e);
            }
        }
        
        return a.toString();
    }
}