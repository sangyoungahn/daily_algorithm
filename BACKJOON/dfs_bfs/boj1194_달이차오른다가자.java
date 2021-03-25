
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj1194_달이차오른다가자 {
	static char[][] map;
	static char[] key;
	static boolean[][][] visited;
	static int N,M;
	static Loc start;
	static int ans;
	static int[] di= {-1,1,0,0};
	static int[] dj= {0,0,-1,1};
	
	static class Loc {
		int x;
		int y;
		int key;	//키 정보
		int cnt;	//
		
		public Loc(int x, int y, int key, int cnt) {
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
		visited = new boolean[N][M][1<<6];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				
				//0인 위치는 객체를 생성에서 변수에 저장해놓음
				if(map[i][j]=='0') {
					start = new Loc(i,j,0,0);
				}
			}
		}//map full
		
//		//output test
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		Queue<Loc> q = new LinkedList<>();
		q.offer(start);	//처음 위치를 큐에 넣어줌
		visited[q.peek().x][q.peek().y][0] = true;
		
		Loc d;
		int currentKey=0;
		while(!q.isEmpty()) {
			d = q.poll();	//큐에서 하나 꺼내오기
			currentKey = d.key;
			
			if(map[d.x][d.y]=='1') {	//출구 찾았으면 리턴
				return d.cnt;
			}
			
			for(int k=0; k<4; k++) {
				int ti = d.x + di[k];
				int tj = d.y + dj[k];
				int key = currentKey;
				
				//범위 넘으면 통과
				if(ti<0 || tj<0 || ti>=N || tj>=M)	continue;
				
				//벽이면 통과
				if(map[ti][tj]=='#')	continue;
				
				//키를 찾으면 저장
				if('a'<=map[ti][tj] && map[ti][tj]<='f') {
					key |= (1 << (map[ti][tj]-'a'));
				}
				
				//해당 키가 있는지 확인해서 없으면 다른 방향 탐색
				if('A'<=map[ti][tj] && map[ti][tj]<='F') {
					if( (key & (1 << (map[ti][tj]-'A'))) == 0 ) {
						continue;
					}
				}
				
				//키를 가지고 방문한 적이 있으면 통과
				if(visited[ti][tj][key])	continue;
				
				//방문한적이 없으면 true 바꿔줌
				visited[ti][tj][key] = true;
				
				//탐색 가능한 모든 곳을 큐에 넣어줌 -> 다음 위치를 탐색하면 현재 위치에서 '+1'을 해줘야 함
				q.offer(new Loc(ti, tj, key, d.cnt+1));
				
			}
			
		}//while
		
		return -1;
	}
}
