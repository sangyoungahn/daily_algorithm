package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int even=0;
			int odd=0;
			int sum=0;
			int num=Integer.parseInt(br.readLine());
			
			for(int i=1;i<=num;i++) {
				if((i%2) == 0)	even -= i;
				else	odd += i;
			}
			sum = even + odd;
			System.out.println("#"+(t+1)+" "+sum);
		}
	}

}
