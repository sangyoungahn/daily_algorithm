package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1945 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int num = Integer.parseInt(br.readLine());
			int cnt2=0;
			int cnt3=0;
			int cnt5=0;
			int cnt7=0;
			int cnt11=0;
			
			//2로 나눠지는 횟수 쭉~~찾고
			int temp = num;
			while(temp%2==0) {
				temp /= 2;
				cnt2++;
			}
			
			//3으로 나눠지는 횟수 쭉~~~찾는 방식
			//temp에 다시 원래의 숫자를 넣어줘야 정확한 값을 구할 수 있음 
			temp = num;
			while(temp%3==0) {
				temp /= 3;
				cnt3++;
			}
			
			temp = num;
			while(temp%5==0) {
				temp /= 5;
				cnt5++;
			}
			
			temp = num;
			while(temp%7==0) {
				temp /= 7;
				cnt7++;
			}
			
			temp = num;
			while(temp%11==0) {
				temp /= 11;
				cnt11++;
			}
			
			System.out.println("#"+(t+1)+" "+cnt2+" "+cnt3+" "+cnt5+" "+cnt7+" "+cnt11);
		}
	}

}
