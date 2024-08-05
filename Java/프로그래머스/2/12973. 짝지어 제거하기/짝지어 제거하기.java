import java.util.*;

class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] str = s.toCharArray();
        
        for (char a : str) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else if (stack.peek() == a) {
                stack.pop();
            } else {
                stack.push(a);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}