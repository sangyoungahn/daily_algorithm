package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj1707_이분그래프 {
	static int[] team;
	static ArrayList<ArrayList<Integer>> graph;
	static int V,E;
	static String ans;
	static int A,B;
	static int RED = 1, GREEN = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 3번 반복
		for(int t=0; t<T; t++) {
			ans = "YES";
			String[] srr = br.readLine().split(" ");
			V = Integer.parseInt(srr[0]);
			E = Integer.parseInt(srr[1]);
			
			// 정점마다 1개의 ArrayList를 만듦 -> 정점마다 연결되는 정점들의 정보를 알아야하므로
			graph = new ArrayList<>();
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<E; i++) {
				srr = br.readLine().split(" ");
				A = Integer.parseInt(srr[0])-1;
				B = Integer.parseInt(srr[1])-1;
				
				// 정점을 서로 연결시켜줌
				graph.get(A).add(B);
				graph.get(B).add(A);
			}
			
			//정점의 수만큼 번호 생성
			team = new int[V];
			//정점을 탐색하며 색칠해줌(그래프끼리 구분)
			for(int i=0; i<V; i++) {
				if(team[i]==0) {
					if(!bfs(i))	break;
				}
			}
			
			System.out.println(ans);
		}
	}

	private static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		team[n] = RED;
		while(!q.isEmpty()) {
			int node = q.poll();
			
			// node와 연결된 것들 모두가 i에 저장
			for(Integer i : graph.get(node)) {
				// 인접한 곳이 나와 같은 팀인지 체크
				if(team[node] == team[i]) {
					ans = "NO";	// 이분 그래프가 아니라는 뜻
					return false;
				}
				//아직 방문하지 않았으면 자신과 반대되는 팀을 넣는다.
				if(team[i]==0) {
					team[i] = team[node] * -1;
					q.add(i);
				}
			}
		}
		
		return true;
	}

}
