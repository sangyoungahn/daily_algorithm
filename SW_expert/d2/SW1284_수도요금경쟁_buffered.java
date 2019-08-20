package day03_1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1284_수도요금경쟁_buffered {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String[] strArr = br.readLine().split(" ");		//한줄을 공백 기준으로 잘라서 넣음
			
			int P=Integer.parseInt(strArr[0]);
			int Q=Integer.parseInt(strArr[1]);
			int R=Integer.parseInt(strArr[2]);
			int S=Integer.parseInt(strArr[3]);
			int W=Integer.parseInt(strArr[4]);
			
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
