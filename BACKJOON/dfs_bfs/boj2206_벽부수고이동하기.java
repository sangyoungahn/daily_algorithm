package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2206_���μ����̵��ϱ� {
	static int[] di = { -1, 1, 0, 0 }; // ��,��,��,��
	static int[] dj = { 0, 0, -1, 1 };

	static int N, M, ans;
	static int[][] visited;
	static int[][] map;

	static class Pos {
		int i;
		int j;
		int dis; // �̵��Ÿ�
		int drill; // ����Ƚ��

		public Pos(int i, int j, int dis, int drill) {
			super();
			this.i = i;
			this.j = j;
			this.dis = dis;
			this.drill = drill;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		map = new int[N][M];
		visited = new int[N][M];

		// input
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;	//���Ѵ�� �ʱ�ȭ
			}
		}
		ans = Integer.MAX_VALUE;

		bfs(0, 0);
		
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void bfs(int si, int sj) {
		Queue<Pos> q = new LinkedList<>();
		// ���������� Ž������
		q.add(new Pos(0, 0, 1, 0));
		visited[si][sj] = 0; // ó�� ����Ƚ��

		// ť�� �� ������ �ݺ�
		while (!q.isEmpty()) {
			Pos pos = q.poll();

			// �̵��� ���� ���� �����̶�� ����
			if (pos.i == N - 1 && pos.j == M - 1) {
				ans = pos.dis;
				break;
			}
			// 4���� Ž��
			for (int dir = 0; dir < 4; dir++) {
				int ni = pos.i + di[dir];
				int nj = pos.j + dj[dir];

				// ������ ������ �ٽ� �ö󰡼� 4���� Ž��
				if (ni < 0 || ni >= N || nj < 0 || nj >= M)
					continue;
				
				// "���� ��ġ�� ����Ƚ�� <= ������ġ�� ����Ƚ��"�̸� ť�� �߰����� �ʰ� �Ѿ�� ��(?????)
				if(visited[ni][nj] <= pos.drill)
					continue;

				// ���� �ƴ� ��
				if(map[ni][nj]==0) {
					visited[ni][nj] = pos.drill;
					q.add(new Pos(ni, nj, pos.dis+1, pos.drill));
				}
				// ���� ��
				else {
					if(pos.drill==0) {
						visited[ni][nj] = pos.drill + 1;
						q.add(new Pos(ni, nj, pos.dis+1, pos.drill+1));
					}
				}
			}
		}
	}

}
