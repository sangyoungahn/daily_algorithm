package swea.d4;
 
import java.io.*;
 
public class SW3459_승차예측하기 {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            long N = Long.parseLong(br.readLine());
            String s = "Alice";
            while(N > 10) {
                N = (N/2) + 1;
                N = (N/2) - 1;
            }
            if( N == 1 || (N >= 6 && N <= 9)){
                s = "Bob";
            }
            bw.write("#"+t+" "+s+"\n");
        }
        br.close();
        bw.close();
    }
 
}