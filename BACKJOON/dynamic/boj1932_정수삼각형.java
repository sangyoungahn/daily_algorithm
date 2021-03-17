package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1932_정수삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n + 1][n + 1];
		int max = 0;

		for (int i = 1; i <= n; i++) {
			String[] srr = br.readLine().split(" ");
//			System.out.println("srr[" + (j - 1) + "] : " + srr[j - 1]);
			for (int j = 1; j <= i; j++) {
				// 한 줄의 숫자를 하나씩 받음
				triangle[i][j] = Integer.parseInt(srr[j - 1]);

				// 분기에 따른 계산
				if (j == 1)
					triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
				else if (i == j)
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
				else
					triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];

				if (triangle[i][j] > max)
					max = triangle[i][j];
			}
		}

		System.out.println(max);
	}
}
