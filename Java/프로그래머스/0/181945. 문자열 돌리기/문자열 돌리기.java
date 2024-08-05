import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] charA = a.toCharArray();
        
        for (char c : charA) {
            System.out.println(c);
        }
    }
}