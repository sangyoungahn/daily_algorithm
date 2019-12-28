package boj1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj1194_달이차오른다가자2 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int result = Integer.MAX_VALUE;
	static Data start;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Data {
		int x,y;
		int key;
		int cnt;
		public Data(int y, int x, int key, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);	//세로
		M = Integer.parseInt(srr[1]);	//가로
		
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];	//000000 ~ 1000000
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
//				System.out.print(map[i][j]);
				
				//출발점이면 탐색 시작
				if(map[i][j]=='0') {
					start = new Data(i, j, 0, 0);
				}
			}
//			System.out.println();
		}//input
		
		result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		Queue<Data> q = new LinkedList<>();
		q.offer(start);
		visited[q.peek().y][q.peek().x][0] = true;
		Data d;
		int currentKey;
		
		while(!q.isEmpty()) {	//큐가 비어있지 않다면
			d = q.poll();	//큐에서 Data타입을 하나 꺼내옴
			currentKey = d.key;
			
			if(map[d.y][d.x] == '1') {	//문을 찾았으면 나가기
				System.out.println("문을 찾음");
				return d.cnt;
			}
			
			//문을 못 찾았다면 4방향 탐색
			for(int i=0; i<4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				int key = currentKey;
				
				//범위 벗어나면 다음것 탐색
				if(nx<0 || nx>=M || ny<0 || ny>=N)	continue;
				
				//벽을 만나면 패스
				if(map[ny][nx] == '#')	continue;
				
				//키를 찾은 경우, 키 값을 비트마스크로 변경
				if('a'<=map[ny][nx] && map[ny][nx]<='f') {
					key |= (1 << (map[ny][nx]-'a'));
				}
				
				//A~F이면 기존 키를 가지고 있는지 확인한 후 없으면 통과(= 다른 곳 탐색)
				System.out.println(nx + ", " + ny + ", " + map[ny][nx]  + " , " + key);
				if('A'<=map[ny][nx] && map[ny][nx]<='F') {
					//"보유하고 있는 키(key)"와 "해당 위치의 알파벳(<<연산으로 인해 A~F 하니씩 검사)" 비교
					//001011 -> a,b,d키를 가지고 있는 것
					if((key & (1<<(map[ny][nx] - 'A'))) == 0);	continue;	//AND연산 후에 0이라고 하면 키가 없는 것!
				}
				
				//기존의 키를 가지고 방문했던 적이 있으면 통과
				if(visited[ny][nx][key])	continue;
				
				//같은 키를 가지고 방문했던 적이 있었는지 방문체크 배열 채우기(방문했던 곳은 다음에 방문하지 못하도록 하기 위해)
				visited[ny][nx][key] = true;
				
				q.offer(new Data(ny, nx, (char)key, d.cnt+1));
			}
		}
		
		//문을 찾을 수 없으면 -1 반환
		return -1;
	}
}
