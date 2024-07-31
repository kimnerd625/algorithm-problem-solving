import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        int[] nums = new int[N];
        for (int i =0; i < N; i++) {
        	nums[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(nums);
        sb.append(nums[N/2]);
        System.out.println(sb);
	}
}