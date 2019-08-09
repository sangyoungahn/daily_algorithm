package com.ssafy.d2;
import java.util.Scanner;

public class swea1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		for(int n=1; n<=num; n++) {
			String strNum = String.valueOf(n);	//toCharArray로 하나하나 보기 위해 int를 String으로 바꿔줌
			char[] ch = strNum.toCharArray();	//146 ->  ch[0]:1  ch[1]:4  ch[2]:6
			int cnt = 0;	//3의 배수의 개수를 세는 변수
			for(int i=0; i<ch.length; i++) {
//				System.out.print(ch[i] - '0' + "|");
				if( (ch[i] - '0') != 0) {	//해당 자리수가 0이 아니라면 3으로 나눠서 나눠지면 카운트 해줌
					if( ((ch[i]-'0') % 3) == 0)
						cnt += 1;
				}
			}
			switch(cnt) {
			case 3:
				System.out.print("--- ");
				break;
			case 2:
				System.out.print("-- ");
				break;
			case 1:
				System.out.print("- ");
				break;
			case 0:
				System.out.print(n + " ");
				break;
			}
		}
	}
}

