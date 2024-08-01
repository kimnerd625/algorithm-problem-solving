import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
        	int T = Integer.parseInt(br.readLine());
        	char[][] map = new char[100][100];
            
            for (int n = 0; n < 100; n++) {
            	char[] temp = br.readLine().trim().toCharArray();
                for (int m = 0; m < 100; m++) {
                    map[n][m] = temp[m];
                }
            }
            
            int maxLength = 1;
            
            // 각 행에서 가장 긴 화문 찾기
            for (int row = 0; row < 100; row++) {
            	for (int start = 0; start < 100; start++) {
                    for (int end = start + maxLength; end < 100; end++) {
                        if (isPalindrome(map[row], start, end)) {
                        	maxLength = Math.max(maxLength, end - start + 1);
                        }
                    }
                }
            }
            
            // 각 열에서 가장 긴 회문 찾기
            for (int col = 0; col < 100; col++) {
            	for (int start = 0; start < 100; start++) {
                	for (int end = start + maxLength; end < 100; end++) {
                    	if (isPalindrome(map, start, end, col)) {
                        	maxLength = Math.max(maxLength, end - start + 1);
                        }
                    }
                }
            }
            sb.append("#").append(T).append(" ").append(maxLength).append("\n");
        }
        System.out.print(sb);
	}
    
    // 가로로 start부터 end까지가 회문인지 검사
    public static boolean isPalindrome(char[] arr, int start, int end) {
    	while (start < end) {
        	if (arr[start] != arr[end]) {
            	return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    // 세로로 start부터 end까지가 회문인지 검사
    public static boolean isPalindrome(char[][] arr, int start, int end, int col) {
    	while (start < end) {
        	if (arr[start][col] != arr[end][col]) {
            	return false;
            }
            start ++;
            end--;
        }
        return true;
    }
}