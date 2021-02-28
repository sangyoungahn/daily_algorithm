package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 1. 풀이시간 : 
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 	(1) 최소값 구하기
 * 		계산하면서 이전 계산값보다 더 커지면 멈춤(백트래킹)
 * 	(2) 최대값 구하기
 * 		
 */
public class boj1488_연산자끼워넣기 {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int[] operator = new int[4];
	static int[] number;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];

		// 숫자 입력
		String[] srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			number[i] = Integer.parseInt(srr[i]);
		}

		// 연산자 입력 -> 순서대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
		srr = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(srr[i]);
		}

		dfs(number[0], 1);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}

	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			
			return;
		}

		// 존재하는 연산자의 개수대로 탐색
		for (int i = 0; i < 4; i++) {
			// 연산자의 개수가 1개 이상인 경우
			if (operator[i] > 0) {
				// 해당 연산자를 사용하므로 1 감소시킴
				operator[i]--;

				// 연산자의 종류에 따라 다음 숫자를 더할지, 뺼지, 곱할지, 나눌지가 정해짐
				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1);
					break;
				case 1:
					dfs(num - number[idx], idx + 1);
					break;
				case 2:
					dfs(num * number[idx], idx + 1);
					break;
				case 3:
					dfs(num / number[idx], idx + 1);
					break;
				}
				
				// 재귀호출이 종료되면 다시 연산자 개수를 복구함
				operator[i]++;
			}
		}
	}

}
