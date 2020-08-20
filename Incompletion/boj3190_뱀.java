package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj3190_�� {
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

	static int snakeX = 0; // �� �Ӽ� �ʱⰪ
	static int snakeY = 0;
	static int snakeDir = 1;

	static int moveCnt = 0; // �� ������ Ƚ��
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> secondList;
	static ArrayList<Character> dirList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // map�� ũ��
		map = new int[N][N];
		visited = new boolean[N][N]; // ���� �ִ��� üũ
		secondList = new ArrayList<Integer>();
		dirList = new ArrayList<Character>();

		int K = Integer.parseInt(br.readLine()); // ����� ����
		for (int i = 0; i < K; i++) {
			String[] applePosition = br.readLine().split(" ");
			int appleX = Integer.parseInt(applePosition[0]);
			int appleY = Integer.parseInt(applePosition[1]);
			// map�� ��� ǥ��
			map[appleX][appleY] = 1;
		}

		int L = Integer.parseInt(br.readLine()); // ���� ���� ��ȯ Ƚ��
		for (int i = 0; i < L; i++) {
			String[] dirInfo = br.readLine().split(" ");
			int second = Integer.parseInt(dirInfo[0]);
			char switchDir = dirInfo[1].charAt(0);
			// ���� ��ȯ ������ ���� ����Ʈ�� ����
			secondList.add(second);
			dirList.add(switchDir);
		}

		// �� ����, ���� ����
		Snake snake = new Snake(snakeX, snakeY, snakeDir);

		// ���⺯���ؾ��ϴ� �� ��������
		outLoop: for (int i = 0; i < secondList.size(); i++) {
			System.out.println("for�� : " + (i + 1) + "��°");
			int second = secondList.get(i);
			System.out.println("second : " + second);
			System.out.println("=======================");

			// �� �����̱�
			while (true) {
				System.out.println("while�� ����");
				// ������ �ٲ��ִ� �κ��� �̵��ϴ� �κк��� ���� ���;� ��!
				// �׷��� ������ �̵��� �ص�, ���� ������ ��� �����ؼ� ������ �ٲ�������
				// �ð��� �ɸ��� ������ �ٲ���
				System.out.println("���� �̵�Ƚ�� : " + moveCnt);
				if (moveCnt == second) {
					System.out.println("�ڡڡڡڡڡ� ���� ���� �ٲٴ� �б� �ɸ� �ڡڡڡڡڡ�");
					// �ɸ� ���ڿ��� ���� �б� ����
					if (dirList.get(i) == 'D') { // ���������� ���� �ٲ�
						switchToRightDir();
					} else if (dirList.get(i) == 'L') { // �������� ���� �ٲ�
						switchToLeftDir();
					}
				}

				// ���� �Ѿ�� �ݺ��� Ż��
				if (snakeX >= N || snakeY >= N) {
					System.out.println("�ڡڡڡڡڡ� ����Ż�� ���� �ɸ� �ڡڡڡڡڡ�");
					break outLoop;
				}
				System.out.println("���� ��ġ : (" + snakeX + ", " + snakeY + ")");
				System.out.println("���� ���� : " + snakeDir);
				if (snakeDir == 1) {
					moveToRight();
				} else if (snakeDir == 2) {
					moveToDown();
				} else if (snakeDir == 3) {
					moveToLeft();
				} else if (snakeDir == 4) {
					moveToUp();
				}

				// �̵� ��, �̵�Ƚ�� �÷���
				moveCnt++;

			}
		}

		System.out.println(moveCnt);
	}

	private static void moveToRight() {
		// �̵��ϴ� ���� ��� O
		if (map[snakeX][snakeY + 1] == 1) {
			visited[snakeX][snakeY] = true; // ������ ��ġ�� �湮üũ
			visited[snakeX][snakeY + 1] = true; // �̵��� ��ġ�� �湮üũ
			// [snakeY + 1] �̷��� �ϸ� �迭�� �ε��� ���� �������ذ��̹Ƿ� static ������ ���� �� �ٲ�
		}
		// �̵��ϴ� ���� ��� X
		else if (map[snakeX][snakeY + 1] == 0) {
			visited[snakeX][snakeY] = false; // ������ ��ġ�� �湮üũ X
			visited[snakeX][snakeY + 1] = true; // �̵��� ��ġ�� �湮üũ
		}
		snakeY += 1;
	}

	private static void moveToLeft() {
		// �̵��ϴ� ���� ��� O
		if (map[snakeX][snakeY - 1] == 1) {
			visited[snakeX][snakeY] = true; // ������ ��ġ�� �湮üũ
			visited[snakeX][snakeY - 1] = true; // �̵��� ��ġ�� �湮üũ
		}
		// �̵��ϴ� ���� ��� X
		else if (map[snakeX][snakeY - 1] == 0) {
			visited[snakeX][snakeY] = false; // ������ ��ġ�� �湮üũ X
			visited[snakeX][snakeY - 1] = true; // �̵��� ��ġ�� �湮üũ
		}
		snakeY -= 1;
	}

	private static void moveToDown() {
		// �̵��ϴ� ���� ��� O
		if (map[snakeX + 1][snakeY] == 1) {
			visited[snakeX][snakeY] = true; // ������ ��ġ�� �湮üũ
			visited[snakeX + 1][snakeY] = true; // �̵��� ��ġ�� �湮üũ
		}
		// �̵��ϴ� ���� ��� X
		else if (map[snakeX + 1][snakeY] == 0) {
			visited[snakeX][snakeY] = false; // ������ ��ġ�� �湮üũ X
			visited[snakeX + 1][snakeY] = true; // �̵��� ��ġ�� �湮üũ
		}
		snakeX += 1;
	}

	private static void moveToUp() {
		// �̵��ϴ� ���� ��� O
		if (map[snakeX - 1][snakeY] == 1) {
			visited[snakeX][snakeY] = true; // ������ ��ġ�� �湮üũ
			visited[snakeX - 1][snakeY] = true; // �̵��� ��ġ�� �湮üũ
		}
		// �̵��ϴ� ���� ��� X
		else if (map[snakeX - 1][snakeY] == 0) {
			visited[snakeX][snakeY] = false; // ������ ��ġ�� �湮üũ X
			visited[snakeX - 1][snakeY] = true; // �̵��� ��ġ�� �湮üũ
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
