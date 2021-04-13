package boj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15649_N과M1 {
	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		
		arr = new int[M];			//뽑은 개수만큼 출력해야하므로 M
		visited = new boolean[N+1];	//dfs() 함수에서 i를 1부터 시작하기 때문에 N+1을 해줌
									//4라고 하면 1~4의 방문여부를 모두 체크해야하기 때문에 N+1
		
		dfs(N,M,0);
	}

	private static void dfs(int N, int M, int cnt) {
		//뽑는 개수와 동일하다면 arr배열을 출력
		if(cnt==M) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		//방문여부를 체크하면서 dfs함수 재귀호출
		for(int i=1; i<=N; i++) {	//i<=N???????
			if(!visited[i]) {
				visited[i]=true;
				arr[cnt]=i;
				dfs(N, M, cnt+1);
				visited[i]=false;	//?????
			}
		}
		
		return;
	}
	
}
