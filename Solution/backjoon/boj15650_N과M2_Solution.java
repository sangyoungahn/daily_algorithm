package boj15650;

import java.util.Scanner;

public class boj15650_N과M2_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		int[] output = new int[N];	//출력할 항목 넣을 배열
		boolean[] visited = new boolean[N];	//탐색여부 확인하는 배열
		perm(arr, output, visited, 0, N, M);	//dfs탐색

	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		//출력해야할 개수와 동일하면 dfs탐색 멈춤
		if (depth == r) {
			//오름차순 정렬에 위배되면 출력하지 않고 반환
			for (int i = 0; i < r - 1; i++) {
				if (output[i] >= output[i + 1])
					return;
			}
			
			//출력
			for (int i = 0; i < r; i++)
				System.out.print(output[i] + " ");
			System.out.println();
		}
		
		for (int i = depth; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}
}