import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2636_치즈 {
	//x, y좌표를 저장하는 클래스
	static class Data {
		int x;
		int y;
		
		
		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] srr = br.readLine().split(" ");
		int r = Integer.parseInt(srr[0]);
		int c = Integer.parseInt(srr[1]);
		
		int[][] map = new int[r][c];
		for(int i=0; i<r; i++) {
			srr = br.readLine().split(" ");
			for(int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
			}
		}//map full
		
//		//output test
//		for(int i=0; i<r; i++) {
//			for(int j=0; j<c; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		Queue<Data> q = new LinkedList<>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				
			}
		}
		
	}

}
