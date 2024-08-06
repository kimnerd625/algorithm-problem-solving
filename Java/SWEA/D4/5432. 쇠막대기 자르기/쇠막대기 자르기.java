import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            Stack<Character> stack = new Stack<>();
            char[] tmp = br.readLine().toCharArray();
            int answer = 0;

            for (int i = 0; i < tmp.length; i++) {
                char a = tmp[i];

                if (a == '(') {
                    stack.push(a);
                } else {
                    stack.pop();
                    if (tmp[i - 1] == '(') {
                        // 레이저인 경우
                        answer += stack.size();
                    } else {
                        // 쇠막대기의 끝인 경우
                        answer += 1;
                    }
                }
            }
            sb.append("#").append(tc + 1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}