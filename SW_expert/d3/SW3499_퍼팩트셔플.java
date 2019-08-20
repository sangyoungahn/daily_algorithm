package com.ssafy.d3;

import java.util.ArrayList;
import java.util.Scanner;

public class SW3499_퍼팩트셔플3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int num = sc.nextInt();
			sc.nextLine();
			ArrayList<String> frontList = new ArrayList<>();
			ArrayList<String> backList = new ArrayList<>();

			String[] strArr = null;		//공백 기준으로 나눈 문자 하나 하나를 저장할 배열


			String str = sc.nextLine();
			strArr = str.split(" ");
			int strLen = strArr.length;
			//front, back 리스트에 값 넣기
			if( (strLen%2) == 0 ) {	//개수가 짝수일때
				for(int idx=0; idx<strLen; idx++) {

					if(idx < (strLen/2) ) {
						frontList.add(strArr[idx]);
					}else {
						backList.add(strArr[idx]);
					}
				}
			} else {	//개수가 홀수일때
				for(int idx=0; idx<strLen; idx++) {

					if(idx <= (strLen/2)) {
						frontList.add(strArr[idx]);
					}else {
						backList.add(strArr[idx]);
					}
				}
			}
			
			System.out.print("#" + (t+1) + " ");
			//출력
			if( (strLen%2) == 0 ) {		//개수가 짝수일때
				for(int i=0; i<(strLen/2); i++) {
					System.out.print(frontList.get(i) + " ");
					System.out.print(backList.get(i) + " ");
				}
			} else {
				for(int i=0; i<(strLen/2); i++) {
					System.out.print(frontList.get(i) + " ");
					System.out.print(backList.get(i) + " ");
				}
				System.out.print(frontList.get(strLen/2));
			}
			System.out.println();
		}
	}
}
