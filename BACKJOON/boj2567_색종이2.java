package boj2567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class boj2567_색종이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[100][100];
		for(int n=0;n<N;n++) {
			String[] srr = br.readLine().split(" ");
			int col = Integer.parseInt(srr[0]);
			int row = Integer.parseInt(srr[1]);
			
			//색종이 하나씩 면적을 모두 칠함
			for(int i=row;i<row+10;i++) {
				for(int j=col;j<col+10;j++) {
					map[i][j]=1;
				}
			}//full
		}
		
//		//출력테스트
//		for(int i=0;i<100;i++) {
//			for(int j=0;j<100;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		//둘레 세기
		int cnt=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1) {
					//왼쪽 변 세기
					if(map[i][j-1]==0)	cnt++;
					
					//오른쪽 변 세기
					if(map[i][j+1]==0)	cnt++;
					
					//위쪽 변 세기
					if(map[i-1][j]==0)	cnt++;
					
					//아래쪽 변 세기
					if(map[i+1][j]==0)	cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
