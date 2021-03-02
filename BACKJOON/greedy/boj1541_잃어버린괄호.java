package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj1541_잃어버린괄호 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split("\\-");
		int sum = add(srr[0]);
		
		for(int i=1; i<srr.length; i++) {
			//add() 함수를 호출하고 나면 -로 나눈 덩어리 숫자들의 합이 더해져서 리턴됨
			sum -= add(srr[i]);
		}
		
		System.out.println(sum);
	}

	// +로 묶인 숫자들을 다 더하는 함수
	private static int add(String str) {
		String[] srr = str.split("\\+");
		int sum = 0;
		for(int i=0; i<srr.length; i++) {
			sum += Integer.parseInt(srr[i]);
		}
		
		return sum;
	}

}
