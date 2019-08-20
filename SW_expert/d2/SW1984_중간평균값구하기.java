package day03_sw1984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1984_중간평균값구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String[] str = br.readLine().split(" ");	//3 17 1
			int[] intArr = new int[10];
			for(int i=0;i<10;i++) {
				intArr[i] = Integer.parseInt(str[i]);
			}
			
			for(int i=0;i<intArr.length;i++) {
				for(int j=i;j<intArr.length;j++) {
					if(intArr[i]>intArr[j]) {
						int temp = intArr[i];
						intArr[i] = intArr[j];
						intArr[j] = temp;
					}
				}
			}
			
			double sum=0;
			int avg=0;
			for(int i=1;i<intArr.length-1;i++) {
				sum += intArr[i];
			}
			avg = (int)Math.round(sum/8);	//반올림
			System.out.println("#"+t+" "+avg);
			
		}
	}

}
