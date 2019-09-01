package test.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * int 입력 받기(공백 존재X)
 */
public class IntInput {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[] srr = br.readLine().split(" ");
			int row = Integer.parseInt(srr[0]);	//행
			int col = Integer.parseInt(srr[1]);	//열

			//숫자 입력 받기(공백 존재X)
			int[][] intArr = new int[row][col];
			for(int i=0;i<row;i++) {
				String s = br.readLine();
				for(int j=0;j<col;j++) {
					intArr[i][j] = s.charAt(j) - '0';
				}
			}
			
			//출력테스트
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					System.out.print(intArr[i][j]);
				}
				System.out.println();
			}
			
			//모든 배열 값들의 합 출력 테스트
			int sum=0;
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					sum += intArr[i][j];
				}
			}
			System.out.println(sum);
		}
	}
	
}