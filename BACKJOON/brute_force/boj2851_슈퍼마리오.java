package boj2851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2851_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] num = new int[10];
		for(int i=0;i<10;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}//full

		int sum=0;
		int a=0,b=0;
		for(int i=0;i<10;i++) {
			sum += num[i];
			if(sum==100)	break;
			else if(sum>100) { //1. 100이 넘으면
				a = sum-100;
				b = 100 - sum + num[i];
				//b = Math.abs(100-sum); -> ?????

				if(a>b) {
					sum=sum-num[i];	//sum이 100이 넘었으므로 더해주는 숫자를 빼줘야 100 아래가 됨
				}
				break;	//2. 다 더한 값이 100이 넘어가면 종료해야 함
			}
		}
		
		System.out.println(sum);
	}
}
