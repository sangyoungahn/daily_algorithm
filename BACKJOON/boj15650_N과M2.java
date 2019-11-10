package boj15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15650_N과M2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);	//1~N개 자연수
		int M = Integer.parseInt(srr[1]);	//M개를 선택해서 출력
		
		int[] arr = new int[N];
		//1~N까지의 arr배열 생성
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		boolean[] visited = new boolean[N];	//방문여부 체크 배열
		int[] result = new int[N];	//출력해야할 배열 -> M개만 있어도 되는것 아닌지????????
		
		dfs(arr,visited,result,0,N,M);	//dfs탐색
	}

	static void dfs(int[] arr, boolean[] visited, int[] result, int depth, int n, int m) {
		//출력해야할 개수와 동일하면 dfs탐색 멈춤
		if(depth==m) {
			//오름차순 정렬에 위배된다면 바로 반환
			for(int i=0; i<m-1; i++) {
				if(result[i]>=result[i+1])	return;
			}
			
			//오름차순 정렬에 위배되지 않는다면 출력
			for(int i=0; i<m; i++)
				System.out.print(result[i]+" ");
			System.out.println();
		}
		
		for(int i=depth; i<n; i++) {
			//아직 방문을 안한 항목이면 탐색 시작
			if(!visited[i]) {
				visited[i]=true;
				
				//dfs핵심!!
				result[depth]=arr[i];	//depth에 따라서 arr의 항목을 계속 변화시키면서 넣어야 됨
				dfs(arr, visited, result, depth+1, n, m);
				visited[i]=false;	//바로 전 단계에서 다시 dfs탐색하기 위해서 전 단계를 false해줌
			}
		}
	}
}