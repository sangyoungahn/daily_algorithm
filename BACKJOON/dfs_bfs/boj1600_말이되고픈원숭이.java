package boj1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1600_말이되고픈원숭이 {
	static int K, W, H;
	static int[][] map;
	//말 치트키를 0~K번 썼을 때 각각의 이동횟수을 저장하기 위한 배열
	static int[][][] dp;
	static int result = Integer.MAX_VALUE;
	
	//원숭이 이동
	static int[] mx = {0,0,-1,1};
	static int[] my = {-1,1,0,0};
	
	//말 이동
	static int[] hx = {-1,-2,1,2,-2,-1,2,1};
	static int[] hy = {-2,-1,-2,-1,1,2,1,2};
	
	static class Monkey {
		int x, y;
		int k;	//말 치트키 이동횟수
		int c;	//이동횟수
		public Monkey(int x, int y, int k, int c) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		String[] srr = br.readLine().split(" ");
		W = Integer.parseInt(srr[0]);
		H = Integer.parseInt(srr[1]);
		
		map = new int[H][W];
		dp = new int[K+1][H][W];
		for(int i=0; i<H; i++) {
			srr = br.readLine().split(" ");
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
//				System.out.print(map[i][j] + " ");
				
				//메모이제이션 최대값으로 초기화
				for(int k=0; k<K+1; k++) {
					dp[k][i][j] = Integer.MAX_VALUE;
				}
			}
//			System.out.println();
		}//input
		
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<Monkey> q = new LinkedList<>();
		//처음 위치의 원숭이를 큐에 삽입
		q.offer(new Monkey(0, 0, 0, 0));
		Monkey m;
		while(!q.isEmpty()) {
			//큐에 있는 원숭이 하나 꺼내기
			m = q.poll();
			
			//기본적인 원숭이 이동 실행
			moveMonkey(m,q);
			
			//말로 이동이 가능하면 말 이동 방법 실행
			if(m.k < K) {
				moveHorse(m,q);
			}
		}
		
		//모든 탐색을 완료하면(= 큐에 아무것도 없는 경우) 이 단계로 진입
		//전체 실행 후, 모든 말 치트키 사용 경우에 최소값 구하기
		for(int k=0; k<K+1; k++) {
			result = Math.min(result, dp[k][H-1][W-1]);
		}
		//삼항 연산자 -> (조건문)? 참일 때 : 거짓일 때
		//result값이 초기에 지정했던 MAX_VALUE값과 같다면 도착지점까지 갈 수 없다는 의미 -> -1 출력
		result = (result == Integer.MAX_VALUE)? -1 : result;
	}

	private static void moveMonkey(Monkey m, Queue<Monkey> q) {
		int nx, ny;
		//파라미터로 넘어온 원숭이의 현재위치에서 4방향으로 이동
		for(int i=0; i<4; i++) {
			nx = m.x + mx[i];
			ny = m.y + my[i];
			//범위를 벗어났을 경우 다음 탐색
			if(nx<0 || nx>=W || ny<0 || ny>=H)	continue;
			//장애물을 만났을 경우 다음 탐색
			if(map[ny][nx] == 1)	continue;
			//이동횟수 증가
			int cnt = m.c + 1;
			//"기존에 이동된 횟수 < 새로 이동했을 때 이동횟수"이면 무시
			if(dp[m.k][ny][nx] <= cnt)	continue;
			//새로운 이동정보 큐에 삽입
			q.offer(new Monkey(nx, ny, m.k, cnt));
			//★★현재까지 이동횟수 메모이제이션
			dp[m.k][ny][nx] = cnt;
		}
	}
	
	private static void moveHorse(Monkey m, Queue<Monkey> q) {
		int nx, ny;
		//말 치트키 사용횟수 증가
		int nK = m.k + 1;
		//파라미터로 넘어온 원숭이의 현재위치에서 8방향으로 이동
		for(int i=0; i<8; i++) {
			nx = m.x + hx[i];
			ny = m.y + hy[i];
			//범위를 벗어났을 경우 다음 탐색
			if(nx<0 || nx>=W || ny<0 || ny>=H)	continue;
			//장애물을 만났을 경우 다음 탐색
			if(map[ny][nx] == 1)	continue;
			//이동횟수 증가
			int cnt = m.c + 1;
			//"기존에 말 치트키를 사용한 이동횟수 <= 새로 이동된 횟수"이면 무시
			if(dp[nK][ny][nx] <= cnt)	continue;
			//말 치트키를 썼으므로 하나 증가시켜서 큐에 삽입해야 함
			q.offer(new Monkey(nx, ny, nK, cnt));
			//★★현재까지 이동횟수 메모이제이션
			dp[nK][ny][nx] = cnt;
		}
	}

}
