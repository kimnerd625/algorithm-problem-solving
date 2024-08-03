import java.util.*;

class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        
        int compareA = Integer.parseInt(sb.toString());
        
        int compareB = 2 * a * b;
        
        return compareA < compareB ? compareB : compareA;
    }
}