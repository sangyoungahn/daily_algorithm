package boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14503_로봇청소기 {
	static int N, M;
	static int r, c, d;
	static int cnt = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dirX = {0,0,-1,1};
	static int[] dirY = {-1,1,0,0};
	static class Node {
		int x;
		int y;
		int d;
		boolean check;
		public Node(int x, int y, int d, boolean check) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.check = check;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);	//가로
		M = Integer.parseInt(srr[1]);	//세로
		
		srr = br.readLine().split(" ");
		r = Integer.parseInt(srr[0]);	//x좌표
		c = Integer.parseInt(srr[1]);	//y좌표
		d = Integer.parseInt(srr[2]);	//방향
		
		map = new int[N][M];
		visited = new boolean[N][M];	//청소했는지 여부
		for(int i=0; i<N; i++) {
			srr = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		}
		
		Node n = new Node(r, c, d, true);
		visited[n.x][n.y] = true;	//처음 현재 위치에서 청소를 해 줌
		cnt++;
		System.out.println("맨처음 : " + cnt);
		System.out.println("["+n.x+"]"+"["+n.y+"]");
		dfs(n.x, n.y, n.d);
		
		System.out.println(cnt);
	}

	private static void dfs(int sx, int sy, int d) {
		int nx = 0, ny = 0;
		//방향에 따라 나눔 - 왼쪽으로 한칸만 이동하게 만들기
		if(d==0) {	//북
			nx = sx + dirX[0];
			ny = sy + dirY[0];
		}else if(d==1) {	//동
			nx = sx + dirX[3];
			ny = sy + dirY[3];
		}else if(d==2) {	//남
			nx = sx + dirX[1];
			ny = sy + dirY[1];
		}else if(d==3) {	//서
			nx = sx + dirX[2];
			ny = sy + dirY[2];
		}
		
		//2-a번
		if(!visited[nx][ny] && map[nx][ny]==0) {	//왼쪽에 청소 안 한 공간 존재, 왼쪽이 벽이 아닐 경우
			visited[nx][ny] = true;	//1번 - 청소해줌
			cnt++;
			System.out.println("처음(1번) : " + cnt);
			
			//거리에 따라 방향 설정
			if(d==0)		d = 1;
			else if(d==1)	d = 2;
			else if(d==2)	d = 3;
			else if(d==3)	d = 0;
			System.out.print("다음 탐색할 방향 : "+d+" ");
			System.out.println("["+nx+"]"+"["+ny+"]");
			System.out.println("=====================");
			dfs(nx, ny, d);	//이동한 곳에서 탐색 시작
		}
		//2-b번
		else if(visited[nx][ny] && map[nx][ny]==0) {	//왼쪽에 청소한 공간 존재, 왼쪽이 벽이 아닐 경우
			//거리에 따라 방향 설정
			if(d==0)		d = 1;
			else if(d==1)	d = 2;
			else if(d==2)	d = 3;
			else if(d==3)	d = 0;
			System.out.print("다음 탐색할 방향 : "+d+" ");
			System.out.println("["+nx+"]"+"["+ny+"]");
			System.out.println("=====================");
			dfs(sx, sy, d);	//이동하지 않고 제자리에서 탐색 시작
		}
//		else if(map[nx][ny]==1) {	//왼쪽에 벽이 있는 경우
//			//거리에 따라 방향 설정
//			if(d==0)		d = 1;
//			else if(d==1)	d = 2;
//			else if(d==2)	d = 3;
//			else if(d==3)	d = 0;
//			System.out.println("벽에 부딪힘");
//			System.out.print("다음 탐색할 방향 : "+d+" ");
//			System.out.println("["+nx+"]"+"["+ny+"]");
//			System.out.println("=====================");
//			dfs(sx, sy, d);	//이동하지 않고 제자리에서 탐색 시작
//		}
		//4방향 탐색
		for(int i=0; i<4; i++) {
			nx = sx + dirX[i];
			ny = sy + dirY[i];
			
			//4방향 모두 탐색 안했거나, 4방향 중 청소를 한 곳이 있거나, 4방향 중 벽이 있을 경우 -> 계속 탐색
			if(i!=3 || visited[nx][ny] || map[nx][ny]==1)
				continue;
			//4방향 모두 청소가 이미 되어있거나, 벽일 경우
			else if(i==3|| visited[nx][ny] || map[nx][ny]==1) {
				if(map[nx][ny]!=1) {	//2-c번 : 뒤쪽이 벽이 아닐 경우
					System.out.print("다음 탐색할 방향 : "+d+" ");
					System.out.println("["+nx+"]"+"["+ny+"]");
					System.out.println("=====================");
					//거리에 따라 방향 설정
					if(d==0)		dfs(nx-1, ny, 0);
					else if(d==1)	dfs(nx-1, ny, 1);
					else if(d==2)	dfs(nx-1, ny, 2);
					else if(d==3)	dfs(nx-1, ny, 3);
					
				}else if(map[nx][ny]==1) {	//2-d번 : 뒤쪽이 벽일 경우 멈춤
					System.out.print("다음 탐색할 방향 : "+d+" ");
					System.out.println("["+nx+"]"+"["+ny+"]");
					System.out.println("=====================");
					System.out.println("종료");
					break;
				}
			}
		}
	}

}
