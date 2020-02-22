package boj4179;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj4179_불_Sol {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static char[][] map;
	static int R, C;
	static Queue<Point> man = new LinkedList<>();
	static Queue<Point> fire = new LinkedList<>();
	static int result = 987654321;
	static boolean[][] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		v = new boolean[R][C]; // 사람 이동 방문체크 처리
		String s = "";
		for (int i = 0; i < R; i++) {
			s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					v[i][j] = true;
					map[i][j] = '.'; // 지나갈 수있도록 처리
					man.offer(new Point(j, i));
				} else if (map[i][j] == 'F') {
					fire.offer(new Point(j, i));
				}
			}
		}
		bfs();
		if (result == 987654321) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
	}

	static void bfs() {
		int cnt = 0;
		int nx;
		int ny;
		loop: while (!man.isEmpty()) {
//         불 먼저 번짐
			int size = fire.size();
			Point p;
			for (int f = 0; f < size; f++) {
				p = fire.poll();
				for (int i = 0; i < 4; i++) {
					nx = p.x + dx[i];
					ny = p.y + dy[i];
//               경계검사
					if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
						continue;
					}
//               불이 번질 수 없으면 처리
					if (map[ny][nx] != '.') {
						continue;
					}
//               불 번짐 처리 후 불 큐에 삽입
					map[ny][nx] = 'F';
					fire.add(new Point(nx, ny));
				}
			}
			
			//size때문에 큐에 이전에 넣었던 원소 개수만큼 돌아서 큐 레밸이 한번씩 퍼지는 것
			size = man.size();	//1
//         사람 만큼 큐 처리
			for (int m = 0; m < size; m++) {
				p = man.poll();
				for (int i = 0; i < 4; i++) {
					nx = p.x + dx[i];
					ny = p.y + dy[i];
//               벽만나면 탈출
					if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
//                  탈출 조건 완성
						result = cnt + 1;
						break loop;
					}
					if (v[ny][nx]) {
						continue;
					}
//               지나갈 수 없으면 처리
					if (map[ny][nx] != '.') {
						continue;
					}
//               이동가능하면  방문처리하고 사람큐에 삽입
					v[ny][nx] = true;
					man.add(new Point(nx, ny));
				}
			}
			cnt++;
		}
	}

}