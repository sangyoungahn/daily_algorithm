package day03_1284;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW1284_수도요금경쟁_scanner {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			
			int P=sc.nextInt();
			int Q=sc.nextInt();
			int R=sc.nextInt();
			int S=sc.nextInt();
			int W=sc.nextInt();
			
			int calA = 0;
			int calB = 0;
			int result = 0;
			
			//A사의 수도요금 계산
			calA = P * W;
			
			//B사의 수도요금 계싼
			if(W>=R)	calB = Q + ((W-R)*S);
			else		calB = Q;
			
			//값 비교
			if(calA<calB)	result = calA;
			else			result = calB;
			
			System.out.println("#"+t+" "+result);
		}
	}

}
