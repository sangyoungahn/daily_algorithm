package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 실전5_10 {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, cnt;

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
//		//output test
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(visited[i][j]);
//			}
//			System.out.println();
//		}

		// 탐색 시작할 위치 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
//					System.out.println("i : " + i + ", " + "j : " + j + "(dfs 시작)");
					findIcecream(i, j);
//					System.out.println("dfs 종료");
					// 탐색을 다 하고 나오면 cnt 증가
					cnt++;
//					System.out.println("cnt : " + cnt);
				}
			}
		}

		System.out.println(cnt);
	}

	private static void findIcecream(int si, int sj) {
		if (map[si][sj] == 1 || visited[si][sj])
			return;

		// 위의 조건에 걸리지 않았다면 탐색 가능하므로 미리 visited를 true로 바꿔줌
		visited[si][sj] = true;

		for (int dir = 0; dir < 4; dir++) {
			int ni = si + di[dir];
			int nj = sj + dj[dir];

			if (ni < 0 || ni >= N || nj < 0 || nj >= M)
				continue;

			if (map[ni][nj] == 0 && !visited[ni][nj]) {
//				System.out.println("ni : " + ni + ", " + "nj : " + nj + "(dfs 진행)");
				findIcecream(ni, nj);
			}
		}
	}

}
