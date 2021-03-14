package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1697_숨바꼭질 {
	static int[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);
		int K = Integer.parseInt(srr[1]);
		check = new int[100001];
		
		// 수빈이와 동생의 위치가 같다면 이동할 필요 X
		if(N==K) {
			System.out.println("0");
			return;
		}
		bfs(N,K);
		
		System.out.println(check[K]);
	}

	private static char[] bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[n] = 0;	//수빈이의 위치를 0으로 초기화
		q.add(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			// 동생의 위치값이 0이 아니면 이미 최솟값을 찾은 것이므로 벗어남 (배열의 크기가 100001이므로 시간을 조금이라도 단축시키기 위함)
			if(check[k] != 0)	break;
			
			// -1 이동
			if((x-1>=0) && check[x-1]==0) {	// -1한 위치가 0보다 커야함. -1한 위치의 check 배열이 0이어야 아직 최솟값 찾지 못했다는 뜻
				q.add(x-1);		// 이동한 위치를 삽입
				check[x-1] = check[x] + 1;	// -1한 위치에서의 최소이동횟수
			}
			// +1 이동
			if((x+1<check.length) && check[x+1]==0) {
				q.add(x+1);
				check[x+1] = check[x] + 1;
			}
			// x2 이동
			if((x*2<check.length) && check[x*2]==0) {
				q.add(x*2);
				check[x*2] = check[x] + 1;
			}
		}
		
		return null;
	}

}
