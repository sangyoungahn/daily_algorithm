package boj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2206_벽부수고이동하기_MySol2 {
	static int N, M;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dirY = {-1,1,0,0};
	static int[] dirX = {0,0,-1,1};
	
	static class Place {
		int y;
		int x;
		int dis;	//이동거리
		int drill;	//벽을 부순 여부
		public Place(int y, int x, int dis, int drill) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.drill = drill;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);	//세로
		int M = Integer.parseInt(srr[1]);	//가로
		
		//visited[0][][] - 벽을 부수지 않고 이동하는 경우
		//visited[1][][] - 벽을 부수고 이동하는 경우
		visited = new boolean[2][N][M];
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		}//input
		bfs();
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void bfs() {
		Queue<Place> q = new LinkedList<>();
		q.offer(new Place(0, 0, 1, 0));
		
		int cnt=0;
		while(!q.isEmpty()) {
			Place place = q.poll();
			int y = place.y;
			int x = place.x;
			int dis = place.dis;
			int drill = place.drill;
			cnt++;
			System.out.println(cnt+"번쨰 "+ "dis : " + dis);
			
			//끝지점이 도착하면 반복문 탈출
			if(y==N-1 && x==M-1) {
				System.out.println("마지막에 도착한 경우");
				ans = dis;
				break;
			}
			
			System.out.println("4방향 탐색 시작");
			//4방향 탐색
			for(int i=0; i<4; i++) {
				int ny = y + dirY[i];
				int nx = x + dirX[i];
				System.out.println("ny : "+ny+", nx : "+nx);
				
				System.out.println("기저대역 검사 시작");
				//기저대역
				if(ny<0 || ny>=N || nx<0 || nx>=M)	continue;
				System.out.println("기저대역 통과");	//여기까지 못 옴
				
				System.out.println("벽 부술까 말까 시작");
				//이미 벽을 한 번 부순 경우
				if(drill==1) {
					System.out.println("벽을 한 번 부순 경우");
					if(!visited[drill][ny][nx] && map[ny][nx]==0) {
						visited[drill][ny][nx] = true;
						q.offer(new Place(ny, nx, dis+1, drill));
					}
				}
				//아직 벽을 안 부순 상태인 경우
				else {
					System.out.println("아직 벽을 안 부순 경우");
					//다음 탐색할 곳이 벽인 경우
					if(map[ny][nx]==1) {
						if(!visited[drill+1][ny][nx]) {
							visited[drill+1][ny][nx] = true;
							q.offer(new Place(ny, nx, dis+1, drill+1));
						}
					}
					//다음 탐색할 곳이 벽이 아닌 경우
					else if(map[ny][nx]==0) {
						if(!visited[drill][ny][nx]) {
							visited[drill][ny][nx] = true;
							q.offer(new Place(ny, nx, dis+1, drill));
						}
					}
				}
			}
			
		}
	}
}
