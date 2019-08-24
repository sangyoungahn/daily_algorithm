import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2567_색종이2_보충 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100+1][100+1];
		int size = Integer.parseInt(reader.readLine());
		String[] srr = null;
		int x, y;
		for(int t=0;t<size;t++) {
			srr = reader.readLine().split(" ");
			x = Integer.parseInt(srr[0]);
			y = Integer.parseInt(srr[1]);
			
			//다 붙임
			for(int i=x;i<x+10;i++) {
				for(int j=y; j<y+10;j++) {
					map[i][j] = 1;
				}
			}
		}
		//다 세기
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] == 1) {
//					왼쪽
					if(map[i][j-1] == 0) {
						cnt++;
					}
//					오른쪽
					if(map[i][j+1] == 0) {
						cnt++;
					}
//					위쪽
					if(map[i-1][j] == 0) {
						cnt++;
					}
//					아래쪽
					if(map[i+1][j] == 0) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		
	}
	
}
