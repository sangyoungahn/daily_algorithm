package boj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2606_바이러스 {
	static int comNum;
	static int linkNum;
	static int cnt;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comNum = Integer.parseInt(br.readLine());
		linkNum = Integer.parseInt(br.readLine());
		
		//for문 안에 두면 for문 돌때마다 초기화되므로 주의!!
		map = new int[comNum+1][comNum+1];
		visited = new boolean[comNum+1];	//comNum+1 주의!!
		
		for(int i=0; i<linkNum; i++) {
			String[] srr = br.readLine().split(" ");
			int a = Integer.parseInt(srr[0]);
			int b = Integer.parseInt(srr[1]);
			
			//연결되어 있는 컴퓨터 판단
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(cnt);
	}

	private static void dfs(int start) {
		visited[start] = true;
		
		for(int i=2; i<comNum+1; i++) {
//			System.out.println("for문 시작");
//			System.out.println(map[start][i]);
			
			//서로 연결되어 있고, i를 아직 방문하지 않았다면
			if(map[start][i]==1 && !visited[i]) {
//				System.out.println("cnt"+"("+i+") : "+cnt);
				cnt++;
				dfs(i);
			}
		}
	}

}
