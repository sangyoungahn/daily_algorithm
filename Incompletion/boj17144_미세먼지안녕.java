package boj17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj17144_미세먼지안녕_4 {
	static int R, C, T;
	static int sum;
	static int[][] map; // 변하지 않는 맵
	static int[][] temp; // 확산되는 값에 따라 변하는 맵
	//확신시킬때 사용
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	//위쪽 공기청정기 이동(오른쪽, 위, 왼쪽, 아래)
	static int[] upDirY = { 0, -1, 0, 0 };
	static int[] upDirX = { 1, 0, -1, 1 };
	//아래쪽 공기청정기 이동(오른쪽, 아래, 왼쪽, 위)
	static int[] downDirY = {0, 1, 0, -1};
	static int[] downDirX = {1, 0, -1, 0};
	
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
		temp = new int[R][C];
		for (int i = 0; i < R; i++) {
			srr = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(srr[j]);
				// 맵 복사
				temp[i][j] = map[i][j];
//				System.out.print(temp[i][j] + " ");
			}
//			System.out.println();
		} // input

		//T초만큼 반복
		for (int t = 0; t < T; t++) {
			spread(); // 미세먼지 확산
		}
		
//		// output test
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(temp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//배열에 있는 값 모두 더함
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += temp[i][j];
			}
		}
		
		System.out.println(sum);
	}

	private static void spread() {
		ArrayList<Node> airCleaner = new ArrayList<>();
		int amount = 0;
		int cnt = 0;
		int subAmount = 0;
		// 0이 아닌 것을 찾음
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 0보다 크면 확산시킴(기존의 맵 기준)
				if (map[i][j] > 0) {
					// 확산되는 양(기존의 맵에서 구해야 함)
					amount = map[i][j] / 5;
//					System.out.println("i : " + i + ", j : " + j + ", amount : " + amount);

					// cnt를 매번 초기화해줘야 cnt가 누적 안 됨
					cnt = 0;

					// 4방향 탐색
					for (int k = 0; k < 4; k++) {
						int nx = i + dirX[k];
						int ny = j + dirY[k];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)
							continue;

						temp[nx][ny] += amount;
//						System.out.println("temp" + "[" + nx + "]" + "[" + ny + "]" + " : " + temp[nx][ny]);
						cnt++;
					}
//					System.out.println("cnt : " + cnt);
					subAmount = amount * cnt;
//					System.out.println("subAmount : " + subAmount);
					if (temp[i][j] - subAmount > 0)
						// 뿌려준 횟수만큼 원래값에서 빼기
						temp[i][j] -= subAmount;
//					System.out.println("temp[중심][중심] : " + temp[i][j]);
//					System.out.println("================================");
				}
				//공지청정기이면 공기 정화
				else if(map[i][j] == -1) {
					temp[i][j] = -1;
					airCleaner.add(new Node(i, j));
				}
			}
		}
		cleanAir(airCleaner.get(0), airCleaner.get(1));

//		// output test
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(temp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("=======================");
	}

	private static void cleanAir(Node up, Node down) {
		//up : 반시계 방향
		//down : 시계 방향
		int dir = 0;
		int before = 0, cur = 0;
		
		//시작점을 공기청정기 바로 오른쪽으로 지정
		int upInitY = up.y + upDirY[dir];
		int upInitX = up.x + upDirX[dir];
		
		//한칸씩 이동
		int upNextY = upInitY + upDirX[dir];
		int upNextX = upInitX + upDirX[dir];
		
		while(temp[upNextY][upNextX] != -1) {
			upNextY = upInitY + upDirY[dir];
			upNextX = upInitX + upDirX[dir];
			
			//배열의 범위를 벗어나면 방향을 바꿔줌
			if(upNextY<0 || upNextY>=R || upNextX<0 || upNextX>=C) {
				dir++;
				upNextY = upInitY + upDirY[dir];
				upNextX = upInitX + upDirX[dir];
			}
		}
		
		//시작점을 공기청정기 바로 오른쪽으로 지정
		int downY = down.y + downDirY[k];
		int downX = down.x + downDirX[k];
			
			
	}

}
