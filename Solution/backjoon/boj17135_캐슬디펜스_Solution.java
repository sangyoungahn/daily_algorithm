import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 17135 캐슬 디펜스
public class Main_BOJ_17135 {
	static int N;  //높이 
	static int M;  //넓이
	static int D;
	static int[][] map;
	static int result = 0;

	static int[] dx = {-1, 0, 1};  // 좌, 상, 우  순서로
	static int[] dy = {0, -1, 0};
	static int alive = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N+1][M];  //궁수 자리 추가해서 배열 선언
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					alive++;
				}
			}
		}
		v = new boolean[M];  // 궁수 선택 체크 배열
		//궁수 3명 선택 
		dfs(0,0);
		System.out.println(result);
	}
	static boolean[] v;
	static void dfs(int idx, int r) {
		if(r == 3) {
			int[][] nMap = new int[N+1][M];
//			배열 데이터 deepCopy
			for(int i =0 ; i < N+1; i++) {
				for(int j = 0 ; j < M; j++) {
					nMap[i][j] = map[i][j];
				}
			}
			solve(nMap, alive);
			return;
		}
		for(int i = idx; i < M; i++) {
			if(v[i]) {
				continue;
			}
			v[i] = true;
			dfs(i, r + 1);
			v[i] = false;
		}
	}
	static void solve(int[][] nMap, int alive) {
		int cnt = 0;
//		 궁수의 위치를 배치 : 궁수는 2로 표시	
		for(int j = 0 ; j < M; j++) {
			if(v[j]) {
				nMap[N][j] = 2;
			}
		}
//		적이 살아 있는 동안 반복하기
		while(alive > 0) {
//			현재 턴에 잡은 적 리스트 저장용
			Queue<Data> q = new LinkedList<>();
			
			for(int x = 0 ; x < M; x++) {
//				궁수 위치 이면 적 탐색 (좌, 상, 우 순으로)				
				if(nMap[N][x] == 2) {
					Queue<Data> q1 = new LinkedList<>();
					boolean v[][] = new boolean[N+1][M];
					q1.add(new Data(N, x));
					Data d;
					while(!q1.isEmpty()) {
						d = q1.poll();
						v[d.y][d.x] = true;
						if(nMap[d.y][d.x] == 1) {//적이 있으면 적 리스트에 추가
							q.add(new Data(d.y, d.x));
//							한 마리만 잡을 수 있음으로 바로 현재 궁수 빠져 나감
							break;
						}

						for(int i = 0 ; i < 3 ; i++) {
							int nx = d.x + dx[i];
							int ny = d.y + dy[i];
							if(nx < 0 || nx >= M || ny < 0|| ny >N) {
								continue;
							}
							if(v[ny][nx]) {
								continue;
							}
							if((Math.abs(N-ny) + Math.abs(x- nx)) > D) {
								continue;
							}
							
							q1.offer(new Data(ny, nx));
						}// for end
					} // while end 탐색 완료
				}// if(nMap[N][x] end
			} //  for 문 end : 궁수 완료
//			맞춘 적 누적하면서 살아있는 적 빼주기, 두 궁수가 같이 잡은 적은 한 명만 세주기
			for(Data d : q) {
				if(nMap[d.y][d.x] == 1) {
					nMap[d.y][d.x] = 0;
					cnt++;
					alive--;
				}
			}
//			사라질 적 갯수 세기
			for(int i = 0 ; i <M; i++) {
				if(nMap[N-1][i] == 1) {
					alive--;
				}
			}
//			적 전진
			for(int i = N-1; i > 0; i--) {
				for(int j = 0; j < M; j++) {
					nMap[i][j] = nMap[i-1][j];
				}
			}					
			// 마지막 라인 초기화
			for(int i = 0; i < M; i++) {
				nMap[0][i] = 0;
			}
//			기존 최대값보다 더 많이 잡을 수 없는 경우에  반복문 벗어나기(가지치기)
			if(cnt + alive <= result) {
				break;
			}
		}// while end	

		result  = Math.max(result, cnt);
	}
	static class Data{
		int x, y;
		public Data(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}