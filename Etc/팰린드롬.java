package exam.KBbank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);

        int result = 0;
        for(int i=n; i<=m; i++) {
            String num = String.valueOf(i);
            StringBuilder sb = new StringBuilder(num);
            String numReverse = sb.reverse().toString();
            if(num.equals(numReverse)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
