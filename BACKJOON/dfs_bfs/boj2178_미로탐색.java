package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2178_미로탐색 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	//위치를 저장하기 위한 클래스
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
		N = Integer.parseInt(srr[0]);	//세로
		M = Integer.parseInt(srr[1]);	//가로
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';	//숫자로 저장됨
			}
		}
		
		int result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0, 0));		//시작위치를 큐에 넣어줌
		int cnt = 1;		//시작할때부터 1로 시작
		
		//큐가 비어있지 않으면 계속 반복
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt++;		//큐의 크기만큼 다 돌고, 새로운 크기를 뽑았다는 것은 다른 depth로 넘어갔다는 뜻
			
			//큐의 크기만큼 반복
			for(int t=0; t<size; t++) {
				Position pos = queue.poll();
				
				//4방향 탐색
				for(int i=0; i<4; i++) {	
					int nx = pos.x + dx[i];
					int ny = pos.y + dy[i];
					
					//범위가 넘으면 다시 올라가서 4방향 탐색
					if(nx<0 || nx>=N || ny<0 || ny>=M)
						continue;
					
					//이동한 값이 map의 끝이면 이동횟수 반환
					if(nx == N-1 && ny == M-1)
						return cnt;
					
					//다음으로 이동하는 곳이 갈 수 있는 곳이고, 아직 탐색하지 않은 곳이면 큐에 넣어 다음에 탐색할 수 있도록 함
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new Position(nx, ny));
						visited[nx][ny] = true;		//탐색하고 나면 탐색했다고 명시
					}
				}
			}
		}
		return 0;
	}

}
