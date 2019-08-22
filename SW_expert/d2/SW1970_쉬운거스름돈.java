package day05.sw1970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SW1970_쉬운거스름돈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine());
			int cnt50000=0;
			int cnt10000=0;
			int cnt5000=0;
			int cnt1000=0;
			int cnt500=0;
			int cnt100=0;
			int cnt50=0;
			int cnt10=0; 
			int mok=0, nam=0;

			while(true) {
				//종료조건
				if(10>N)	break;
				if(N>=50000) {
					mok = N/50000;			
					nam = N%50000;
					cnt50000 += mok;
					N = nam;	//N을 새로운 몫으로 넣어줌
				}else if(50000>N && N>=10000) {
					mok = N/10000;
					nam = N%10000;
					cnt10000 += mok;
					N = nam;
				}else if(10000>N && N>=5000) {
					mok = N/5000;
					nam = N%5000;
					cnt5000 += mok;
					N = nam;
				}else if(5000>N && N>=1000) {
					mok = N/1000;
					nam = N%1000;
					cnt1000 += mok;
					N = nam;
				}else if(1000>N && N>=500) {
					mok = N/500;
					nam = N%500;
					cnt500 += mok;
					N = nam;
				}else if(500>N && N>=100) {
					mok = N/100;
					nam = N%100;
					cnt100 += mok;
					N = nam;
				}else if(100>N && N>=50) {
					mok = N/50;
					nam = N%50;
					cnt50 += mok;
					N = nam;
				}else if(50>N && N>=10) {
					mok = N/10;
					nam = N%10;
					cnt10 += mok;
					N = nam;
				}
				
				
			}
			System.out.println("#"+tc);
			System.out.println(cnt50000+" "+cnt10000+" "+cnt5000+" "+cnt1000+" "+cnt500+" "+cnt100+" "+cnt50+" "+cnt10);
		}//tc

	}
}
