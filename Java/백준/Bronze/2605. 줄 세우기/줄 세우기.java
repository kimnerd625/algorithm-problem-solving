import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[T];
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        
        for (int i = 0; i < T; i++) {
            if (arr[i] == 0) {
                stack.push(i+1);
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    temp.push(stack.pop());
                }
                stack.push(i+1);
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
        }
        
        while(!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        
        while (!temp.isEmpty()) {
            System.out.print(temp.pop() + " ");
        }
    }
}