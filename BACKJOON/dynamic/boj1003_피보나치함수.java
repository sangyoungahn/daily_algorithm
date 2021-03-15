package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1003_피보나치함수_Sol {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] fibo = new int[41][2];
		fibo[0][0] = 1;
		fibo[1][1] = 1;
		
		//규칙 수식화
		for(int i=2; i<41; i++) {
			for(int j=0; j<2; j++) {
				fibo[i][j] = fibo[i-1][j] + fibo[i-2][j];
			}
		}
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(fibo[N][0] + " " + fibo[N][1]);
		}
	}

}
