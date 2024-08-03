import java.util.*;

class Solution {
    public int solution(int a, int b) {
        StringBuilder m = new StringBuilder();
        StringBuilder n = new StringBuilder();
        
        m.append(a);
        m.append(b);
        
        n.append(b);
        n.append(a);
        
        return Integer.parseInt(m.toString()) < Integer.parseInt(n.toString()) ? Integer.parseInt(n.toString()) : Integer.parseInt(m.toString());
    }
}