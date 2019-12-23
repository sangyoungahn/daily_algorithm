import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 백준 2933 미네랄
public class Main_BOJ_2933 {

	static int R,C;		// 행, 열 갯수
	static int N;		// 막대기 수
	static char[][] map;

	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char [R][C];
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}

		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int L = R-sc.nextInt();
//			 미네랄 부수기
			solve1(L,i);
//			 미네랄 재배치
			solve2();
		}
//		미네랄 배치 출력
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void solve2() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		ArrayList<Node> cluster = new ArrayList<>();

		// 땅에 붙어있는 클러스터 체크 , 하나가 아니라 땅에 붙어 있는 클러스터는 여러개 있을 수 있음
		for (int c = 0; c < C; c++) {
			if(v[R-1][c]) { // 방문했던 위치 무시
				continue;
			}
			if(map[R-1][c] =='.' ) {  // 미네랄 없으면 무시
				continue;
			}
			v[R-1][c] = true;  // 방문 체크 해주고
			q.add(new Node(R-1, c));  //  연결된 클러스터 파악하기(BFS)
			while(!q.isEmpty()) {
				Node node = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
//					범위 벗어나면 무시
					if(nx < 0 || nx >= C || ny < 0 || ny >=R) {
						continue;
					}
//					방문 했던곳 무시
					if( v[nx][ny] ) {
						continue;
					}
//					미네랄 아니면 무시
					if(map[nx][ny] =='.') {
						continue;
					}
//					새로운 곳 방문 체크
					v[nx][ny] = true;
//					새롭게 큐에 넣어서 미네랄 클러스터 확인
					q.add(new Node(nx, ny));
				}
			}
		}

		// 공중에 떠 있는 클러스터 찾기. (땅에서부터 시작해서 방문하지 못한 미네랄을 검색)
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!v[i][j] && map[i][j] == 'x') {
					map[i][j] = '.';	// 임시적으로 클러스터 삭제 이동파악하기 쉽게
					cluster.add(new Node(i, j));
				}
			}
		}

		if(cluster.isEmpty()) {	// 공중에 떠있는 미네랄 없으면 무시
			return ;
		}

		// 공중에 떠있는 클러스터를 아래로 이동할 수 있는지 파악해서 아래축으로 이동 가능한 만큼 아래로 증가하기
		boolean down = true;
		while(down) {
			for(Node node : cluster) {
				int nx = node.x +1;
				int ny = node.y;
//				범위 벗어나면 떨어질 수 없어서 무시
				if(nx < 0 || nx >= C || ny < 0 || ny >= R) {
					down = false;
					break;
				}
//				떨어질 곳에 미네랄 있으면 떨어질 수 없어서 무시
				if( map[nx][ny] == 'x') {
					down = false;
					break;
				}
			}
//			떨어질 수 있으면 모든 미네랄 아래로 하나씩 증가하기
			if(down) {
				for(Node node : cluster) {
					node.x++;
				}
			}
		}

		// 공중에 떠 있던 미네랄 덩어리 재배치하기
		for(Node node : cluster) {
			map[node.x][node.y] = 'x';
		}

	}

	static void solve1 (int L, int i) {
//		미네랄 부수기 ( 왼쪽, 오른쪽 방향에서 하나만 ) 
		if(i % 2 == 0) {
			for (int j = 0; j < C; j++) {
				if(map[L][j] == 'x') {
					map[L][j] = '.';
					break;
				}
			}    
		}
		else {
			for (int j = C-1; j >= 0; j--) {
				if(map[L][j] == 'x') {
					map[L][j] = '.';
					break;
				}
			}
		}
	}
	static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}


