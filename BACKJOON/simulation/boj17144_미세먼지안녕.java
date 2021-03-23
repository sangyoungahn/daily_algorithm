package boj17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj17144_미세먼지안녕_MySol {
	static int R, C, T;
	static int sum;
	static int[][] map; // 변하지 않는 맵
	// 확신시킬때 사용
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	// 위쪽 공기청정기 이동(오른쪽, 위, 왼쪽, 아래)
	static int[] upDirY = { 0, -1, 0, 1 };
	static int[] upDirX = { 1, 0, -1, 0 };
	// 아래쪽 공기청정기 이동(오른쪽, 아래, 왼쪽, 위)
	static int[] downDirY = { 0, 1, 0, -1 };
	static int[] downDirX = { 1, 0, -1, 0 };

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		R = Integer.parseInt(srr[0]);
		C = Integer.parseInt(srr[1]);
		T = Integer.parseInt(srr[2]);

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			srr = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
			}
		} // input

		// T초만큼 반복
		for (int t = 0; t < T; t++) {
			spread(); // 미세먼지 확산
		}

		// 배열에 있는 값 모두 더함
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1)
					sum += map[i][j];
			}
		}

		System.out.println(sum);
	}

	private static void spread() {
		ArrayList<Node> airCleaner = new ArrayList<>();
		int dust = 0;
		int[][] dusts = new int[R][C];
		int cnt = 0;
		// 0이 아닌 것을 찾음
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 0보다 크면 확산시킴(기존의 맵 기준)
				if (map[i][j] > 0) {
					// 확산되는 양(기존의 맵에서 구해야 함)
					dust = map[i][j] / 5;

					// cnt를 매번 초기화해줘야 cnt가 누적 안 됨
					cnt = 0;

					// 4방향 탐색
					for (int k = 0; k < 4; k++) {
						int nx = i + dirX[k];
						int ny = j + dirY[k];

						//4방향 탐색했을 때 범위를 벗어나거나, 공기청정기가 있으면 더하면 안 됨
						if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)
							continue;
						
						//확산은 모든 칸에서 동시에 일어나야 함
						//확산되는 먼지만 따로 저장해두는 배열을 만듦
						dusts[nx][ny] += dust;
						cnt++;
					}
					// 뿌려준 횟수만큼 원래값에서 빼기
					map[i][j] -= dust * cnt;
				}
			}
		}
		//확신된 먼지들을 한번에 확산된 값이 빠진 배열에 더함
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(dusts[i][j] != 0) {
					map[i][j] += dusts[i][j];
					
				}
			}
		}
		//공기청정기 일 때 돌림
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1)
					airCleaner.add(new Node(i, j));
			}
		}
		
		cleanAir(airCleaner.get(0), airCleaner.get(1));
	}

	private static void cleanAir(Node up, Node down) {
		// up : 반시계 방향
		// down : 시계 방향

		// 위쪽 공기청정기 처리
		int dir = 0;
		int before = 0, current = 0;

		// 시작점을 공기청정기 바로 오른쪽으로 지정
		int y = up.y + upDirY[dir];
		int x = up.x + upDirX[dir];

		// 한칸씩 이동
		int ny = y + upDirY[dir];
		int nx = x + upDirX[dir];

		while (map[ny][nx] != -1) {
			// 계속 반복해서 이동하기 위해'
			ny = y + upDirY[dir];
			nx = x + upDirX[dir];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
				// 배열의 범위를 벗어나면 방향을 바꿔줌
				dir++;
				if(dir==4)	break;
				// 배열의 범위를 벗어난 상태에서 탐색하지 않기 위해 다음값을 탐색함
				ny = y + upDirY[dir];
				nx = x + upDirX[dir];
			}

			// 현재 위치의 값을 cur에 보관
			current = map[y][x];
			// 전의 값을 현재 위치에 넣음
			map[y][x] = before;
			// current값을 다음 이동했을 때 전의 값으로 써야함
			before = current;

			// 다음값을 현재값으로 바꿔줌
			x = nx;
			y = ny;
		}

		// 아래쪽 공기청정기 처리
		dir = 0;
		before = 0;
		current = 0;

		// 시작점을 공기청정기 바로 오른쪽으로 지정
		y = down.y + downDirY[dir];
		x = down.x + downDirX[dir];

		// 한칸 씩 이동
		ny = y + downDirY[dir];
		nx = x + upDirX[dir];

		while (map[ny][nx] != -1) {
			ny = y + downDirY[dir];
			nx = x + downDirX[dir];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
				// 배열의 범위를 벗어나면 방향을 바꿔줌
				dir++;
				// 배열의 범위를 벗어난 상태에서 탐색하지 않기 위해 다음값을 탐색함
				ny = y + downDirY[dir];
				nx = x + downDirX[dir];
			}

			// 현재 위치의 값을 cur에 보관
			current = map[y][x];
			// 전의 값을 현재 위치에 넣음
			map[y][x] = before;
			// current값을 다음 이동했을 때 전의 값으로 써야함
			before = current;

			// 다음값을 현재값으로 바꿔줌
			x = nx;
			y = ny;
		}

	}// end of cleanAir

}
