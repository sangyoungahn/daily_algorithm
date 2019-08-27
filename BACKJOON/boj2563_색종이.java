package boj2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[100][100];
		int cnt=0;	//1인 부분을 세는 변수
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0;n<N;n++) {
			String[] srr = br.readLine().split(" ");
			int col=Integer.parseInt(srr[0]);
			int row=Integer.parseInt(srr[1]);

			//각 색종이 영역 그리기(1로 채움)
			for(int i=row;i<row+10;i++) {
				for(int j=col;j<col+10;j++) {
					map[i][j]=1;
				}
			}
		}

		//전체 map을 돌면서 1인 부분 세기
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1)	cnt++;
			}
		}

		System.out.println(cnt);
	}

}
