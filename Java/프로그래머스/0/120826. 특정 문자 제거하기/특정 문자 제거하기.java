class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder a = new StringBuilder();
        char letterChar = letter.charAt(0);
        for (char e : my_string.toCharArray()) {
            if (e != letterChar) {
                a.append(e);
            } 
        }
        
        return a.toString();
    }
}