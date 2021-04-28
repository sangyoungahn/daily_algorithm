package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 실전5_11 {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, cnt;

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	
	static class Pos {
		int i;
		int j;
		
		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0,0));
	}

	private static Integer bfs(int si, int sj) {
		Queue<Pos> q = new LinkedList<Pos>();
		// 큐에 우선 넣어줌
		q.add(new Pos(si, sj));
		
		// 큐가 빌 떄까지 반복
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			// 이 부분 주의!!
			si = pos.i;
			sj = pos.j;
			
//			// 이동한 값이 종료지점이라면 탐색 종료
//			if(pos.i == N-1 && pos.j == M-1)	break;
			
			//4방향 탐색
			for(int dir=0; dir<4; dir++) {
				int ni = si + di[dir];
				int nj = sj + dj[dir];
				
				// 공간을 벗어나는 경우 무시
				if(ni<0 || ni>=N || nj<0 || nj>=M)	continue;
				
				// 벽인 경우 무시
				if(map[ni][nj] == 0)	continue;
				
				// 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
				if(map[ni][nj]==1) {
					map[ni][nj] = map[si][sj] + 1;
					q.add(new Pos(ni, nj));
				}
			}
		}
		
		return map[N-1][M-1];
	}
}
