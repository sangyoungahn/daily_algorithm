package boj2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2573_빙산4 {
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	static boolean[][] visited;
	static int N, M;
	static int ice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);	//행
		M = Integer.parseInt(srr[1]);	//열
		ice = 0;
		int year = 0;
		
		int[][] map = new int[N][M];		//실제값을 저장하는 배열
		int[][] zeroMap = new int[N][M];	//주변의 0의 개수를 저장하는 배열
		visited = new boolean[N][M];
//		int[][] afterMap = new int[N][M];	//"실제값-주변의 0의 개수"를 저장한 배열
		
		
		 
		for(int i=0; i<N; i++) {
			srr = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
			}
		}//map full
		
//		//map output test
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
//		int ice=0;	//이어져있는 빙하의 개수
//		int result=0;
		
		//빙하가 두덩이가 될때까지 반복해야하므로!
		while(ice<2) {
			//한 단계를 시작할때마다 1년씩 증가
			
			//배열을 탐색하면서
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int cnt=0;
					//0이 아닌 값이면
					if(map[i][j]!=0) {
						//주변의 0의 개수를 저장
						for(int k=0; k<4; k++) {
							int ti=i+di[k];
							int tj=j+dj[k];
							
							if(ti<0 || ti>=N || tj<0 || tj>=M)	continue;
							//상,하,좌,우로 움직였을 때 0이면 카운트에 저장
							if(map[ti][tj]==0)	cnt++;
						}
						
						//4방향 탐색 다 돌고나서 "0의 개수만 저장하는 배열"에 값 저장
						zeroMap[i][j] = cnt;
					}
				}
			}
			
//			//zeroMap output test
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(zeroNum[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			//"실제값-주변의 0의 개수"를 배열에 저장
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = map[i][j] - zeroMap[i][j];
				}
			}
			
//			//afterMap output test
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			//배열 탐색하면서 빙하 덩어리 개수 알아내기
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					//0이 아니거나, 탐색을 하지 않은 곳이라면 탐색을 시작
					if(map[i][j]!=0 && !visited[i][j]) {
						//findIce함수가 다 돌고 나오면 하나의 덩어리를 탐색했다는 뜻
						findIce(i, j, map, visited);
						ice++;
					}
				}
			}
			
			//배열을 한번 다 탐색해야 1년이 지나감
			year++;
			
//			//종료조건(빙하가 2덩이가 되면 종료)
//			if(ice>=2) {
//				System.out.println(year);
//				break;
//			} else if(ice==0) {
//				if(ice>=2) {
//					year=year-2;
//					System.out.println(year);
//				}
//			}
		}
		
	}

	//빙하의 덩어리 개수를 알아냄
	private static void findIce(int si, int sj, int[][] map, boolean[][] visited) {
		for(int k=0; k<4; k++) {
			int ti = si+di[k];
			int tj = sj+dj[k];
			
			//배열 범위 넘으면 다른 곳에서 다시 탐색
			if(ti<0 || ti>=N || tj<0 || tj>=M)	continue;
			
			//사방이 0이거나, 탐색을 했을 경우 반복 종료
			if(map[ti][tj]!=0 && visited[ti][tj]==false) {
				visited[ti][tj]=true;
				findIce(ti, tj, map, visited);
			}
		}
//		ice++;
//		System.out.println("ice : " + ice);
		
	}

}
