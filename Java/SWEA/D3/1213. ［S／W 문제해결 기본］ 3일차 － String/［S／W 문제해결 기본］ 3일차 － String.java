import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 0; tc < 10; tc++) {
            int T = Integer.parseInt(br.readLine());
        	String checkWord = br.readLine();
            String text = br.readLine();
            
            int count = 0;
            int index = 0;
            
            while ((index = text.indexOf(checkWord, index)) != -1) {
            	count++;
                index += checkWord.length(); // 단어 길이만큼 index를 증가시켜 중복 카운팅 방지
            }
            
            // 결과를 StringBuilder에 추가
            sb.append("#").append(tc+1).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
	}
}