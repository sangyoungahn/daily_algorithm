package boj4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj4963_섬의개수 {
	static int[] di= {-1,-1,-1,0,0,1,1,1};
	static int[] dj= {-1,0,1,-1,1,-1,0,1};
	static boolean[][] visited;
	static int w, h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//w,h가 0이 될때까지 반복
		while(true) {
			String[] srr = br.readLine().split(" ");
			w = Integer.parseInt(srr[0]);
			h = Integer.parseInt(srr[1]);
			int[][] map = new int[h][w];
			visited = new boolean[h][w];
			
			//w,h가 0이면 반복 종료
			if(w==0 && h==0)	break;

			for(int i=0; i<h; i++) {
				String[] srr2 = br.readLine().split(" ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(srr2[j]);
				}
			}//full
			
//			//출력테스트
//			for(int i=0; i<h; i++) {
//				for(int j=0; j<w; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			int answer=0;
			//탐색 시작위치 찾기
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					//현재 위치가 섬이고, 탐색을 하지 않은 곳이라면 dfs탐색!
					if(map[i][j]==1 && !visited[i][j]) {
						findIsland(i,j,map,visited);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	public static void findIsland(int si, int sj, int[][] map, boolean[][] visited) {
		//시작위치가 바다이거나, 탐색을 한 곳이라면 리턴
		if(map[si][sj]==0 || visited[si][sj]==true) return;
		
		//위의 조건에 걸리지 않았다면 탐색 가능하므로  미리 visited를 true로 바꿔줌
		visited[si][sj]=true;
		
		//8방향을 dfs로 탐색
		for(int i=0;i<8;i++) {
			int ti = si + di[i];
			int tj = sj + dj[i];
			
			//범위를 벗어나면 다른 위치에서 다시 탐색해야함
			if(ti<0 || ti>=h || tj<0 || tj>=w)	continue;
			//탐색한 다음 부분이 섬이고, 방문하지 않은 곳이라면 다시 섬을 찾는 함수를 재귀호출
			if(map[ti][tj]==1 && visited[ti][tj]==false) {
				findIsland(ti, tj, map, visited);
			}
		}
		
		return;
	}

}
