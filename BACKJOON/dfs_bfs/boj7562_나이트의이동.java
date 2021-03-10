package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7562_나이트의이동 {
	static int[] di = {-1,-2,-2,-1,1,2,2,1};	//8방향 탐색
	static int[] dj = {-2,-1,1,2,2,1,-1,-2};
	
	static int[][] map;
	static boolean[][] visited;
	static int ei,ej;
	
	static class Pos{
		int i;
		int j;
		int dis;
		
		public Pos(int i, int j, int dis) {
			super();
			this.i = i;
			this.j = j;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 3번 반복
		for(int t=0; t<T; t++) {
			int I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			visited = new boolean[I][I];
			String[] srr = br.readLine().split(" ");
			int si = Integer.parseInt(srr[0]);
			int sj = Integer.parseInt(srr[1]);
			
			srr = br.readLine().split(" ");
			ei = Integer.parseInt(srr[0]);
			ej = Integer.parseInt(srr[1]);
			
			bfs(si,sj);
		}
	}

	private static void bfs(int si, int sj) {
		Queue<Pos> q = new LinkedList<>();
		// 시작점을 큐에 삽입
		// 처음에는 이동거리를 가장큰 수로 잡음
		q.add(new Pos(si, sj, 0));
		visited[si][sj] = true;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			
			// 다음 이동위치가 도착점이라면 최단거리를 출력하고 종료
			// 방향 탐색 안에서 하면 안됨 <- 마지막 위치까지 탐색하고 큐에 넣어야되기 때문
			if(pos.i==ei && pos.j==ej) {
				System.out.println(pos.dis);
				return;
			}
			
			// 8방향 탐색
			for(int dir=0; dir<8; dir++) {
				int ni = pos.i + di[dir];
				int nj = pos.j + dj[dir];
				
				// 범위를 넘어서면 다시 탐색
				if(ni<0 || ni>=map.length || nj<0 || nj>=map.length)
					continue;
				
				// 아직 방문한 곳이 아니라면, 방문을 하고 큐에 넣어줌
				if(!visited[ni][nj]) {
					visited[ni][nj] = true;
					q.add(new Pos(ni, nj, pos.dis+1));
				}
			}
		}
	}
}
