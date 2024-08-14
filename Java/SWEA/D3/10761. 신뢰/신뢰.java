import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();  // Number of test cases
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();  // Number of buttons to press
            
            int axisO = 1;  // Starting position of O robot
            int axisB = 1;  // Starting position of B robot
            
            int timeO = 0;  // Total time for O robot
            int timeB = 0;  // Total time for B robot
            int timeSpent = 0;  // Total time spent
            
            for (int n = 0; n < N; n++) {
                String robot = sc.next();
                int btn = sc.nextInt();
                
                if (robot.equals("O")) {
                    // Calculate time for O to reach the button
                    timeO = Math.max(timeSpent, timeO + Math.abs(axisO - btn)) + 1;
                    axisO = btn;  // Update position of O
                    timeSpent = timeO;  // Update the time spent
                } else {
                    // Calculate time for B to reach the button
                    timeB = Math.max(timeSpent, timeB + Math.abs(axisB - btn)) + 1;
                    axisB = btn;  // Update position of B
                    timeSpent = timeB;  // Update the time spent
                }
            }
            
            System.out.println("#" + (t + 1) + " " + timeSpent);
        }
    }
}