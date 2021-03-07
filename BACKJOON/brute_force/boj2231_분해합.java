package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 풀이시간 : 
 * 2. 예상 시간복잡도 : O()
 * 3. 풀이방법
 * 
 */

public class boj2231_분해합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		// 1~N까지 반복 -> 모든 경우 탐색
		for(int i=0; i<N; i++) {
			int number = i;
			int sum = 0;	//각 자릿수 합
			
			while(number != 0) {
				sum += number % 10;	// 각 자릿수 더하기
				number /= 10;
			}
			
			if(i + sum == N) {	// "원래의 숫자 + 각 자릿수 누적합 = 분해합"일 경우 생성자를 찾은 것
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
