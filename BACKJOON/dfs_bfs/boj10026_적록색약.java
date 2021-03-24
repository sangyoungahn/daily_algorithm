package boj10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026_적록색약_MySol {
	static int N;
	static int normalCnt = 0, blindnessCnt = 0;
	static char[][] map;
	static boolean[][] visited;
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		} // input

		// 정상인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					normalCnt++;
					dfs(i, j);
				}
			}
		}

		// R=G 동일하게 바꿔주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		//방문 배열도 다시 초기화
		visited = new boolean[N][N];

		// 적록색약
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					blindnessCnt++;
					dfs(i, j);
				}
			}
		}

		System.out.println(normalCnt + " " + blindnessCnt);
	}

	private static void dfs(int sx, int sy) {
		visited[sx][sy] = true;
		char c = map[sx][sy];

		for (int i = 0; i < 4; i++) {
			int nx = sx + dirX[i];
			int ny = sy + dirY[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
				if (map[nx][ny] == c)
					dfs(nx, ny);
			}
		}
	}

}
