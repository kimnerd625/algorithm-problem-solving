import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int W = sc.nextInt();
        int H = sc.nextInt();
        
        List<Integer> WList = new ArrayList<>();
        List<Integer> HList = new ArrayList<>();
        
        WList.add(0);
        HList.add(0);
        
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int hv = sc.nextInt();
            int num = sc.nextInt();
            
            if (hv == 0) {
                HList.add(num);
            } else {
                WList.add(num);
            }
        }
        
        WList.add(W);
        HList.add(H);
        
        Collections.sort(WList);
        Collections.sort(HList);
        
        int WLength = 0;
        for (int i = 1; i < WList.size(); i++) {
            WLength = Math.max(WLength, WList.get(i) - WList.get(i - 1));
        }
        
        int HLength = 0;
        for (int i = 1; i < HList.size(); i++) {
            HLength = Math.max(HLength, HList.get(i) - HList.get(i - 1));
        }
        
        System.out.println(WLength * HLength);
    }
}