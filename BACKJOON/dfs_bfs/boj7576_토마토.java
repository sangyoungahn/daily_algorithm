package boj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7576_토마토_2 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int day;
	
	//i,j좌표를 저장할 Data클래스
	static class Data {
		int i;
		int j;
		int status;
		
		Data(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] srr = br.readLine().split(" ");
		M = Integer.parseInt(srr[0]);	//가로길이
		N = Integer.parseInt(srr[1]);	//세로길이
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			srr = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
			}
		}//full
		
		Queue<Data> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//map을 탐색하면서 처음부터 익어있는 토마토를 큐에 넣어줌(모두 넣어주고나서 탐색 시작)
				if(map[i][j]==1 && !visited[i][j]) {
					visited[i][j] = true;
					q.offer(new Data(i,j));	//처음에 무조건 시작위치를 큐에 넣는다
				}
			}
		}
		
//		//출력테스트
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		//bfs 탐색 시작
		day=0;
		bfs(q,map,visited);
		
		//모든 토마토가 다 익었는지 검사
		if(checkTomato())	System.out.println(day-1);
		else	System.out.println(-1);
	}

	static void bfs(Queue<Data> q, int[][] map, boolean[][] visited) {
		while(!q.isEmpty()) {	//큐가 비지 않았으면
			int size=q.size();
			
			//큐에 들어가있는 개수만큼 큐에서 데이터를 빼줌(=처음에 익은 토마토의 개수만큼 뺌)
			for(int k=0;k<size;k++) {
				Data d = q.poll();	//큐에서 데이터를 하나 꺼내 거기서부터 상하좌우 탐색을 시작함

				for(int i=0; i<4; i++) {	//4방향 탐색
					int ti=d.i+di[i];
					int tj=d.j+dj[i];

					//배열이 범위 넘으면 다른 방향을 탐색
					if(ti<0 || ti>=N || tj<0 || tj>=M)	continue;

					//4방향을 갔을때, 다음 데이터가 0이고 방문을 안한 데이터라면 1로 바꿔주고 큐에 넣어줌
					if(map[ti][tj]==0 && visited[ti][tj]==false) {
						visited[ti][tj] = true;
						map[ti][tj] = 1;	//방문한 곳은 1로 변경
						q.offer(new Data(ti,tj));	//단계별로 넣어줘야하기 때문에 여기서 넣어줌
					}
				}
			}
			day++;	//큐에 들어가있는 데이터 하나하나가 모두 4방향 탐색을 완료하면 하루가 증가!!
		}//while - 탐색종료
	}
	
	static boolean checkTomato() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0)	return false;
			}
		}
		return true;
	}

}