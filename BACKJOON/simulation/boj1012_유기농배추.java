package boj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1012_유기농배추 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static int M;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] srr = br.readLine().split(" ");
			M = Integer.parseInt(srr[0]);	//가로 길이(열)
			N = Integer.parseInt(srr[1]);	//세로 길이(행)
			int K = Integer.parseInt(srr[2]);	//배추의 위치
			
			int[][] map = new int[N][M];
			visited = new boolean[N][M];
			for(int k=0; k<K; k++) {
				srr = br.readLine().split(" ");
				int j = Integer.parseInt(srr[0]);	//가로
				int i = Integer.parseInt(srr[1]);	//세로
				map[i][j] = 1;
			}//map full
			
//			//출력테스트
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			//탐색 시작 위치 정하기
			int answer=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
//						answer = 0;	//여기서 초기화 해주면 안됨!!! 1인 위치에 갈 때마다 answer가 0으로 초기화 되버림!! 
						visited[i][j] = true;
						findArea(i,j,map,visited);
						answer++;
					}
				}
			}
			
			System.out.println(answer);
		}//tc
	}

	public static void findArea(int si, int sj, int[][] map, boolean[][] visited) {
		//4방향 dfs
		for(int i=0; i<4; i++) {
			int ti = si + di[i];
			int tj = sj + dj[i];
			
			if(ti<0 || ti>=N || tj<0 || tj>=M)	continue;
			
			if(map[ti][tj]==1 && !visited[ti][tj]) {
				visited[ti][tj] = true;
				findArea(ti, tj, map, visited);
			}
		}
	}

}
