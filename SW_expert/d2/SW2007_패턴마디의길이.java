package day01.sw2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2007_패턴마디의길이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			String str=br.readLine();	//문자열 받기
//			int size=str.length();		//문자열의 크기
			
			char[] ch = str.toCharArray();	//문자열을 하나씩 잘라서 문자로 저장
			char first = ch[0];		//첫번째 문자 저장
			char second = ch[1];	//두번째 문자 저장
			int idx=0;	//출력할 문자의 길이
			
			//문자열 찾기
			for(int i=1;i<10;i++) {
				if(ch[i]==first && ch[i+1]==second) {
					idx=i;
					break;
				}
			}
			System.out.println("#"+t+" "+idx);

		}
	}
			
}

