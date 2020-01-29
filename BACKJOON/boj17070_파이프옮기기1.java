package boj17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class boj17070_파이프옮기기_MySol {
	static int N;
	static int[][] map;
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] srr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		} // input

		// 1부터 시작이지만, 나는 0부터 시작으로 잡음
		dfs(0, 1, 0);
		System.out.println(result);
	}

	private static void dfs(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			result++;
			return;
		}

		// 현재 방향이 아래가 아니고, 오른쪽 칸이 비어있다면 => 오른쪽 탐색
		if (dir != 2 && isRange(r, c + 1) && map[r][c + 1] == 0) {
			dfs(r, c + 1, 0);
		}

		// 현재 방향이 오른쪽이 아니고, 아래칸이 비어있다면 => 아래 탐색
		if (dir != 0 && isRange(r + 1, c) && map[r + 1][c] == 0) {
			dfs(r + 1, c, 2);
		}

		// 오른쪽, 아래, 대각선 모두 비어있다면 => 대각선 탐색
		if (isRange(r + 1, c + 1) && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0) {
			dfs(r + 1, c + 1, 1);
		}
	}

	// 범위 조건
	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

}
