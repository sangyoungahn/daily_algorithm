package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2748_피보나치수2_MySol {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long first = 0;
		long second = 1;
		long sum = first + second;

		second = sum;
		first = second;
		if (n == 0) {
			sum = 0;
		} else {
			for (int i = 0; i < n - 2; i++) {
				sum = first + second;
//			System.out.println("sum : " + sum);

				first = second;
				second = sum;
//			System.out.println("first : " + first);
//			System.out.println("second : " + second);
//			System.out.println("=====================");
			}
		}
		System.out.println(sum);
	}
}