package day01.sw2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2005_파스칼의삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			int n=Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int val=0;
			
			//값 만들기
			System.out.println("#"+t);
			for(int i=0;i<n;i++) {
				map[i][0]=1;	//고정
				for(int j=0;j<n;j++) {	//범위를 벗어나면 for문으로 올라가서 다시 탐색
					if(i-1<0 || j-1<0) {
						continue;
					}
					map[i][j] = map[i-1][j-1] + map[i-1][j];
				}
			}
			
			//값 출력
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==0) {
						continue;
					}
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
