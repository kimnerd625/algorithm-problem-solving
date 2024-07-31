import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int x =0; x < 10; x++) {
        	int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            
            int[] nums = new int[101];
            for (int i = 0; i < 100; i ++) {
                nums[Integer.parseInt(arr[i])] += 1;
            }
            
            int min = 0;
            int max = 100;
            
            while (nums[min] == 0) {
            	min += 1;
            }
            while (nums[max] == 0) {
            	max -= 1;
            }
            
            for (int i =0; i < n; i++) {
            	if(max - min <= 1) break;
                nums[max] -= 1;
                nums[max-1] += 1;
                nums[min] -= 1;
                nums[min+1] += 1;
                if (nums[max] == 0) max -= 1;
                if (nums[min] == 0) min += 1;
            }
            
            sb.append(String.format("#%s: %s\n", x+1, max-min));
        }
        
        System.out.println(sb);
	}
}