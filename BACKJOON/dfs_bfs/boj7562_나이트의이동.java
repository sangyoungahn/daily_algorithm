package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7562_����Ʈ���̵� {
	static int[] di = {-1,-2,-2,-1,1,2,2,1};	//8���� Ž��
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
		
		// �׽�Ʈ���̽� 3�� �ݺ�
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
		// �������� ť�� ����
		// ó������ �̵��Ÿ��� ����ū ���� ����
		q.add(new Pos(si, sj, 0));
		visited[si][sj] = true;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			
			// ���� �̵���ġ�� �������̶�� �ִܰŸ��� ����ϰ� ����
			// ���� Ž�� �ȿ��� �ϸ� �ȵ� <- ������ ��ġ���� Ž���ϰ� ť�� �־�ߵǱ� ����
			if(pos.i==ei && pos.j==ej) {
				System.out.println(pos.dis);
				return;
			}
			
			// 8���� Ž��
			for(int dir=0; dir<8; dir++) {
				int ni = pos.i + di[dir];
				int nj = pos.j + dj[dir];
				
				// ������ �Ѿ�� �ٽ� Ž��
				if(ni<0 || ni>=map.length || nj<0 || nj>=map.length)
					continue;
				
				// ���� �湮�� ���� �ƴ϶��, �湮�� �ϰ� ť�� �־���
				if(!visited[ni][nj]) {
					visited[ni][nj] = true;
					q.add(new Pos(ni, nj, pos.dis+1));
				}
			}
		}
	}
}
