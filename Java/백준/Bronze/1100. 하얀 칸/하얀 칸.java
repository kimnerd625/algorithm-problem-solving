import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isWhiteFirst = true;
        int answer = 0;
        
        for (int i = 0; i < 8; i++) {
            String[] tempLine = br.readLine().split("");
            if (isWhiteFirst) {
                for (int j = 0; j < 8; j+= 2) {
                    if (tempLine[j].equals("F")) answer ++;
                }
            } else {
                for (int j = 1; j < 8; j+=2) {
                    if (tempLine[j].equals("F")) answer ++;
                }
            }
            isWhiteFirst = !isWhiteFirst;
        }
        
        System.out.println(answer);
        
    }
}