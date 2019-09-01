package test.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문자 입력 받기(공백 존재X)
 */
public class CharInput {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[] srr = br.readLine().split(" ");
			int row = Integer.parseInt(srr[0]);	//행
			int col = Integer.parseInt(srr[1]);	//열

			//문자 입력 받기(공백 존재X)
			char[][] chArr = new char[row][col];
			for(int i=0;i<row;i++) {
				String s = br.readLine();
				for(int j=0;j<col;j++) {
					chArr[i][j] = s.charAt(j);
				}
			}
			//출력테스트
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					System.out.print(chArr[i][j]);
				}
				System.out.println();
			}
		}
	}
	
}