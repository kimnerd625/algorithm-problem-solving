import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
        	String word = br.readLine();
            char[] charArr = word.toCharArray();
            
            int isPalindrome = 1;
            
            for (int j = 0; j < charArr.length / 2; j++) {
            	if (charArr[j] != charArr[charArr.length - j - 1]) {
                	isPalindrome = 0;
                    break;
                }
            }
            
            sb.append("#").append(i+1).append(" ").append(isPalindrome).append("\n");
        }
        
        System.out.println(sb);
	}
}