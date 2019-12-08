import java.util.ArrayList;
import java.util.Scanner;
// 백준 15685 드래곤 커브
public class Main_BOJ_15685 {


//	좌표 검사하는 경우 오른쪽 아래쪽 검사 안함
	static int[][] map = new int[101][101]; // 좌표가 포함되는 모든 경우
	static int result = 0;
	public static void main(String[] args) {
		int N;  //커브의 갯수
		int sx, sy;  //커브의 시작 좌표
		int d;     //커브의 시작 방향 → - 0, ↑ - 1, ← - 2, ↓ - 3
		int g;	  //커브의 세대
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i =0; i < N; i++) {
			sx = sc.nextInt();
			sy = sc.nextInt();
			d = sc.nextInt();
			g = sc.nextInt();
//			드래곤 커브 만들기
			makeCurve(sx, sy, d, g);
		}
//		사각형 영역 카운트 검사하기
		checkRect();
		System.out.println(result);

	}
	private static void checkRect() {
		for (int i = 0; i < 100; i++) { 
			for (int j = 0; j < 100; j++) { 
				if(map[i][j] == 0) {
					continue;
				}
				if(map[i][j+1] == 0) {
					continue;
				}
				if(map[i+1][j] == 0) {
					continue;
				}
				if(map[i+1][j+1] == 0) {
					continue;
				}
				result++;
			}
		}
	}
	private static void makeCurve(int x, int y, int d, int g) {
		/*
		 * 0: x좌표 증가 (우) 
		 * 1: y좌표 감소 (상)
		 * 2: x좌표 감소 (좌)
		 * 3: y좌표 증가 (하)
		 */
		 //커브의 시작 방향 → - 0, ↑ - 1, ← - 2, ↓ - 3
		ArrayList<Integer> dirList = makeDirection(d, g);
		map[x][y] = 1;
		for(int dir : dirList) {
			switch(dir) {
			case 0 : //우
				map[++x][y] = 1;
				break;
			case 1 : //상
				map[x][--y] = 1;
				break;
			case 2 : //좌
				map[--x][y] = 1;
				break;
			case 3 : //하
				map[x][++y] = 1;
				break;
			}
		}
		

	}
	private static ArrayList<Integer> makeDirection(int d, int g) {
		ArrayList<Integer> dirList = new ArrayList<>();
		dirList.add(d);
		for(int i = 0; i < g; i++) {
			for(int j = dirList.size()-1; j >=0; j--) {
				int newDir = (dirList.get(j) + 1) % 4;
				dirList.add(newDir);
			}
		}
		return dirList;
	}

}





