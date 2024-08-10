import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            String[] lineA = br.readLine().split(" ");
            String[] lineB = br.readLine().split(" ");
            
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            
            for (int i = 1; i < lineA.length; i++) {
                A.add(Integer.parseInt(lineA[i]));
            }
            
            for (int i = 1; i < lineB.length; i++) {
                B.add(Integer.parseInt(lineB[i]));
            }
            
            Collections.sort(A, Collections.reverseOrder());
            Collections.sort(B, Collections.reverseOrder());
            
            boolean isDraw = true;
            int size = Math.min(A.size(), B.size());
            
            for (int i = 0; i < size; i++) {
                int tempA = A.get(i);
                int tempB = B.get(i);
                
                if (tempA > tempB) {
                    sb.append("A").append("\n");
                    isDraw = false;
                    break;
                } else if (tempA < tempB) {
                    sb.append("B").append("\n");
                    isDraw = false;
                    break;
                }
            }
            
            if (isDraw) {
                if (A.size() > B.size()) {
                    sb.append("A").append("\n");
                } else if (A.size() < B.size()) {
                    sb.append("B").append("\n");
                } else {
                    sb.append("D").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}