package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj3190_뱀 {
	static class Snake {
		int x;
		int y;
		int dir;

		public Snake(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static int snakeX = 0; // 뱀 속성 초기값
	static int snakeY = 0;
	static int snakeDir = 1;

	static int moveCnt = 0; // 뱀 움직인 횟수
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> secondList;
	static ArrayList<Character> dirList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // map의 크기
		map = new int[N][N];
		visited = new boolean[N][N]; // 뱀이 있는지 체크
		secondList = new ArrayList<Integer>();
		dirList = new ArrayList<Character>();

		int K = Integer.parseInt(br.readLine()); // 사과의 개수
		for (int i = 0; i < K; i++) {
			String[] applePosition = br.readLine().split(" ");
			int appleX = Integer.parseInt(applePosition[0]);
			int appleY = Integer.parseInt(applePosition[1]);
			// map에 사과 표시
			map[appleX][appleY] = 1;
		}

		int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
		for (int i = 0; i < L; i++) {
			String[] dirInfo = br.readLine().split(" ");
			int second = Integer.parseInt(dirInfo[0]);
			char switchDir = dirInfo[1].charAt(0);
			// 방향 변환 정보를 각각 리스트에 삽입
			secondList.add(second);
			dirList.add(switchDir);
		}

		// 뱀 생성, 전역 변수
		Snake snake = new Snake(snakeX, snakeY, snakeDir);

		// 방향변봔해야하는 초 빼내오기
		outLoop: for (int i = 0; i < secondList.size(); i++) {
			System.out.println("for문 : " + (i + 1) + "번째");
			int second = secondList.get(i);
			System.out.println("second : " + second);
			System.out.println("=======================");

			// 뱀 움직이기
			while (true) {
				System.out.println("while문 실행");
				// 방향을 바꿔주는 부분이 이동하는 부분보다 먼저 나와야 함!
				// 그렇지 않으면 이동을 해도, 뱀의 방향이 계속 동일해서 방향이 바뀌지않음
				// 시간에 걸리면 방향을 바꿔줌
				System.out.println("뱀의 이동횟수 : " + moveCnt);
				if (moveCnt == second) {
					System.out.println("★★★★★★ 뱀의 방향 바꾸는 분기 걸림 ★★★★★★");
					// 걸린 문자열에 따라 분기 나눔
					if (dirList.get(i) == 'D') { // 오른쪽으로 방향 바꿈
						switchToRightDir();
					} else if (dirList.get(i) == 'L') { // 왼쪽으로 방향 바꿈
						switchToLeftDir();
					}
				}

				// 범위 넘어가면 반복문 탈출
				if (snakeX >= N || snakeY >= N) {
					System.out.println("★★★★★★ 범위탈출 조건 걸림 ★★★★★★");
					break outLoop;
				}
				System.out.println("뱀의 위치 : (" + snakeX + ", " + snakeY + ")");
				System.out.println("뱀의 방향 : " + snakeDir);
				if (snakeDir == 1) {
					moveToRight();
				} else if (snakeDir == 2) {
					moveToDown();
				} else if (snakeDir == 3) {
					moveToLeft();
				} else if (snakeDir == 4) {
					moveToUp();
				}

				// 이동 후, 이동횟수 늘려줌
				moveCnt++;

			}
		}

		System.out.println(moveCnt);
	}

	private static void moveToRight() {
		// 이동하는 곳에 사과 O
		if (map[snakeX][snakeY + 1] == 1) {
			visited[snakeX][snakeY] = true; // 원래의 위치에 방문체크
			visited[snakeX][snakeY + 1] = true; // 이동후 위치에 방문체크
			// [snakeY + 1] 이렇게 하면 배열의 인덱스 값만 변경해준것이므로 static 변수의 값은 안 바뀜
		}
		// 이동하는 곳에 사과 X
		else if (map[snakeX][snakeY + 1] == 0) {
			visited[snakeX][snakeY] = false; // 원래의 위치에 방문체크 X
			visited[snakeX][snakeY + 1] = true; // 이동후 위치에 방문체크
		}
		snakeY += 1;
	}

	private static void moveToLeft() {
		// 이동하는 곳에 사과 O
		if (map[snakeX][snakeY - 1] == 1) {
			visited[snakeX][snakeY] = true; // 원래의 위치에 방문체크
			visited[snakeX][snakeY - 1] = true; // 이동후 위치에 방문체크
		}
		// 이동하는 곳에 사과 X
		else if (map[snakeX][snakeY - 1] == 0) {
			visited[snakeX][snakeY] = false; // 원래의 위치에 방문체크 X
			visited[snakeX][snakeY - 1] = true; // 이동후 위치에 방문체크
		}
		snakeY -= 1;
	}

	private static void moveToDown() {
		// 이동하는 곳에 사과 O
		if (map[snakeX + 1][snakeY] == 1) {
			visited[snakeX][snakeY] = true; // 원래의 위치에 방문체크
			visited[snakeX + 1][snakeY] = true; // 이동후 위치에 방문체크
		}
		// 이동하는 곳에 사과 X
		else if (map[snakeX + 1][snakeY] == 0) {
			visited[snakeX][snakeY] = false; // 원래의 위치에 방문체크 X
			visited[snakeX + 1][snakeY] = true; // 이동후 위치에 방문체크
		}
		snakeX += 1;
	}

	private static void moveToUp() {
		// 이동하는 곳에 사과 O
		if (map[snakeX - 1][snakeY] == 1) {
			visited[snakeX][snakeY] = true; // 원래의 위치에 방문체크
			visited[snakeX - 1][snakeY] = true; // 이동후 위치에 방문체크
		}
		// 이동하는 곳에 사과 X
		else if (map[snakeX - 1][snakeY] == 0) {
			visited[snakeX][snakeY] = false; // 원래의 위치에 방문체크 X
			visited[snakeX - 1][snakeY] = true; // 이동후 위치에 방문체크
		}
		snakeX -= 1;
	}

	private static void switchToRightDir() {
		if (snakeDir == 1)
			snakeDir = 2;
		else if (snakeDir == 2)
			snakeDir = 3;
		else if (snakeDir == 3)
			snakeDir = 4;
		else if (snakeDir == 4)
			snakeDir = 1;
	}

	private static void switchToLeftDir() {
		if (snakeDir == 1)
			snakeDir = 4;
		else if (snakeDir == 2)
			snakeDir = 1;
		else if (snakeDir == 3)
			snakeDir = 2;
		else if (snakeDir == 4)
			snakeDir = 3;
	}

}
