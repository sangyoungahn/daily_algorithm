package boj17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj17135_캐슬디펜스 {
	static int[][] map;
	static int N,M,D;
	static int result;
	static ArrayList<Point> enemy;
	static class Point {
		int r;
		int c;
		Boolean death;
		public Point(int r, int c, Boolean death) {
			super();
			this.r = r;
			this.c = c;
			this.death = death;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		D = Integer.parseInt(srr[2]);
		
		map = new int[N][M];
		for(int row=0; row<N; row++) {
			srr = br.readLine().split(" ");
			for(int col=0; col<M; col++) {
				map[row][col] = Integer.parseInt(srr[col]);
				//적이 있으면 배열에 넣음
				if(map[row][col]==1) {
					enemy.add(new Point(row, col, false));
				}
//				System.out.print(map[row][col]);
			}
//			System.out.println();
		}//input
		
		
	}

}
