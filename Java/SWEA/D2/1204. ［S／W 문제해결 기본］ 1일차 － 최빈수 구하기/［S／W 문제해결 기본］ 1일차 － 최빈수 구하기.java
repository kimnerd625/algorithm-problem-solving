import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int x = 0; x < T; x++) {
        	int tc = Integer.parseInt(br.readLine());
            
            String[] arr = br.readLine().split(" ");
            
            int[] nums = new int[101];
            
            for (int i = 0; i <1000; i++) {
            	nums[Integer.parseInt(arr[i])] += 1;
            }
            
            int answer = 0;
            int maxVal = 0;
            for (int j = 0; j < 101; j++) {
            	if (nums[j] >= maxVal) {
                	maxVal = nums[j];
                    answer = j;
                }
            }
            
            sb.append(String.format("#%s %s\n", tc, answer));
        }
        System.out.println(sb);
	}
}