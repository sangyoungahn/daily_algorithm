package boj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2667_단지번호붙이기_MySol {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}//full
		
//		//출력테스트
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		//탐색 시작 위치 찾는 반복문
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//1이고, 방문하지 않은 곳이라면 탐색 시작
				if(map[i][j]==1 && !visited[i][j]) {
					visited[i][j] = true;	//중요!!
					//반환값을 ArrayList에 넣어줌
					answer.add(findArea(i,j,map,visited));
				}
			}
		}
		
		//오름차순으로 정렬
		Collections.sort(answer);
		
		//출력
		System.out.println(answer.size());
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	private static int findArea(int si, int sj, int[][] map, boolean[][] visited) {
		int cnt = 1;
		
		//시작값이 0이면 0을 반환
		if(map[si][sj]==0)	return 0;
		
		//4방향 dfs탐색
		for(int i=0; i<4; i++) {
			int ti = si + di[i];
			int tj = sj + dj[i];
			
			//배열 범위 넘으면 다른 곳에서 다시 탐색
			if(ti<0 || ti>=N || tj<0 || tj>=N)	continue;
			
			//탐색한 다음 위치가 1이고, 방문을 하지 않은 곳이라면 다시 dfs탐색!!
			if(map[ti][tj]==1 && !visited[ti][tj]) {
				visited[ti][tj] = true;		//중요!!
				
				//findArea가 끝까지 갔다가 복귀할때 cnt가 하나씩 증가함
				cnt += findArea(ti, tj, map, visited);
//				cnt++;	//이렇게 하면 왜 안되는지...
			}
		}
		
		return cnt;
	}

}
