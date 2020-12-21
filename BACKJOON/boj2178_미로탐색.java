package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2178_�̷�Ž�� {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	//��ġ�� �����ϱ� ���� Ŭ����
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);	//����
		M = Integer.parseInt(srr[1]);	//����
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';	//���ڷ� �����
			}
		}
		
		int result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0, 0));		//������ġ�� ť�� �־���
		int cnt = 1;		//�����Ҷ����� 1�� ����
		
		//ť�� ������� ������ ��� �ݺ�
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt++;		//ť�� ũ�⸸ŭ �� ����, ���ο� ũ�⸦ �̾Ҵٴ� ���� �ٸ� depth�� �Ѿ�ٴ� ��
			
			//ť�� ũ�⸸ŭ �ݺ�
			for(int t=0; t<size; t++) {
				Position pos = queue.poll();
				
				//4���� Ž��
				for(int i=0; i<4; i++) {	
					int nx = pos.x + dx[i];
					int ny = pos.y + dy[i];
					
					//������ ������ �ٽ� �ö󰡼� 4���� Ž��
					if(nx<0 || nx>=N || ny<0 || ny>=M)
						continue;
					
					//�̵��� ���� map�� ���̸� �̵�Ƚ�� ��ȯ
					if(nx == N-1 && ny == M-1)
						return cnt;
					
					//�������� �̵��ϴ� ���� �� �� �ִ� ���̰�, ���� Ž������ ���� ���̸� ť�� �־� ������ Ž���� �� �ֵ��� ��
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new Position(nx, ny));
						visited[nx][ny] = true;		//Ž���ϰ� ���� Ž���ߴٰ� ���
					}
				}
			}
		}
		return 0;
	}

}
