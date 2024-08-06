import java.util.Scanner;

public class Solution {
	public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
        	int T = sc.nextInt();
            sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int answer = multiply(a, b);
            System.out.println("#" + T + " " + answer);
        } 
        sc.close();
    }
    
    public static int multiply (int a, int b) {
    	if (b == 0) {
            return 1;
        } else {
            return a * multiply(a, b - 1);
        }
    }
}