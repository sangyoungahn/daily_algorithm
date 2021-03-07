package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15651_N��M3 {
	static int[] num;
	static int N, M;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);	// 1~N
		M = Integer.parseInt(srr[1]);	// ���� ����
		num = new int[N+1];
		
		permutation(0);
		System.out.println(result);
	}

	private static void permutation(int depth) {
		// ������ŭ ������ ����Ǿ� �ִ� ���ڵ��� ���
		if(depth == M) {
			for(int i=0; i<M; i++) {
				result.append(num[i] + " ");
			}
			result.append("\n");
		} else {
			for(int i=1; i<=N; i++) {
				num[depth] = i;
				permutation(depth + 1);
			}
		}
	}

}
