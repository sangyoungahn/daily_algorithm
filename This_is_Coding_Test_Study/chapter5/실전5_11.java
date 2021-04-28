package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ����5_11 {
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
		// ť�� �켱 �־���
		q.add(new Pos(si, sj));
		
		// ť�� �� ������ �ݺ�
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			// �� �κ� ����!!
			si = pos.i;
			sj = pos.j;
			
//			// �̵��� ���� ���������̶�� Ž�� ����
//			if(pos.i == N-1 && pos.j == M-1)	break;
			
			//4���� Ž��
			for(int dir=0; dir<4; dir++) {
				int ni = si + di[dir];
				int nj = sj + dj[dir];
				
				// ������ ����� ��� ����
				if(ni<0 || ni>=N || nj<0 || nj>=M)	continue;
				
				// ���� ��� ����
				if(map[ni][nj] == 0)	continue;
				
				// �ش� ��带 ó�� �湮�ϴ� ��쿡�� �ִ� �Ÿ� ���
				if(map[ni][nj]==1) {
					map[ni][nj] = map[si][sj] + 1;
					q.add(new Pos(ni, nj));
				}
			}
		}
		
		return map[N-1][M-1];
	}
}
