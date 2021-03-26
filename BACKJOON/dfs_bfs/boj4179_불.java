package boj4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj4179_불_MySol {
	static char[][] map;
	static boolean[][] visited;
	static Queue<Node> fire = new LinkedList<>();
	static Queue<Node> man = new LinkedList<>();
	static int min = -1;
	static int R, C;
	static int dirX[] = {0,0,-1,1};
	static int dirY[] = {-1,1,0,0};
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		R = Integer.parseInt(srr[0]);
		C = Integer.parseInt(srr[1]);
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
//				System.out.print(map[i][j]);
				if(map[i][j]=='F') {
					fire.add(new Node(i, j));
				}
				else if(map[i][j]=='J') {
					visited[i][j] = true;
					map[i][j] = '.';	//갈 수 있는 곳으로 바꿔줌
					man.add(new Node(i, j));
				}
			}
//			System.out.println();
		}
		
		bfs();
		System.out.println(min == -1 ? "IMPOSSIBLE" : min);
	}

	private static void bfs() {
		int cnt = 0;
		int nx, ny;
		
		loop: while(!man.isEmpty()) {
			//불 먼저 퍼짐
			int size = fire.size();
			Node n;
			for(int f=0; f<size; f++) {
				n = fire.poll();
				for(int i=0; i<4; i++) {
					nx = n.x + dirX[i];
					ny = n.y + dirY[i];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C)
						continue;
					
					if(map[nx][ny] != '.')
						continue;
					
					map[nx][ny] = 'F';
					fire.add(new Node(nx, ny));
				}
			}
			
			size = man.size();
			for(int m=0; m<size; m++) {
				n = man.poll();
				for(int i=0; i<4; i++) {
					nx = n.x + dirX[i];
					ny = n.y + dirY[i];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C) {
						min = cnt+1;
						break loop;
					}
					
					if(visited[nx][ny])
						continue;
					
					if(map[nx][ny] != '.')
						continue;
					
					visited[nx][ny] = true;
					man.add(new Node(nx, ny));
				}
			}
			
			cnt++;
		}
	}
}