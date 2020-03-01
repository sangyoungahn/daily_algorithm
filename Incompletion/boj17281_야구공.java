package boj17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17281_야구공 {
	static int N;
	static int[][] map;
	static boolean[] visit;
	static int[] player;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이닝
		map = new int[N][10];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		}//input
		visit = new boolean[10];
		player = new int[10];	//player : 1~9
		player[4] = 1;	//4번 선수는 1에 배치
		perm(1);
		System.out.println(max);
	}

	private static void perm(int len) {
		//4번 선수일 경우 첫번쨰에 배치했으므로 다음으로 넘어감
		if(len == 4) {
			perm(len + 1);
			return;
		}
		if(len == 10) {	//선수를 다 배치했을 경우 게임 시작
			int score = playGame();
			max = (max<score)? score : max;
			return;
		}
		
		//선수를 배치(순열)
		for(int i=2; i<10; i++) {
			if(visit[i])	continue;
			player[len] = i;
			visit[i] = true;
			perm(len+1);
			visit[i] = false;
		}
	}

	private static int playGame() {
		int score = 0;
		int out;
		int hitter = 1;
		boolean[] roo = new boolean[4];
		
		for(int inning = 0; inning < N; inning++) {
			//이닝이 시작하면 out을 초기화 시켜줘야 함
			out = 0;
			Arrays.fill(roo, false);
			while(true) {
				int now = map[inning][player[hitter]];
				
				//다음 순서의 타자를 정해줌
				if(hitter == 9)	hitter = 1;
				else	hitter++;
				
				//이닝에서 얻은 결과에 따른 처리
				if(now == 1) {	//안타
					if(roo[3]) {	//3루에 선수가 있을 경우
						score++;
						roo[3] = false;
					}
					for(int r=2; r>1; r--) {	//1~2루에 선수가 있을 경우
						roo[r] = false;
						roo[r+1] = true;
					}
					roo[1] = true;	//1루에도 선수가 가게 됨
				} else if(now == 2) {	//2루타
					if(roo[3]) {
						score++;
						roo[3] = false;
					}
					if(roo[2]) {
						score++;
						roo[2] = false;
					}
					if(roo[1]) {
						roo[3] = true;
						roo[1] = false;
					}
					roo[2] = true;	//2루에도 선수가 가게 됨
				} else if(now == 3) {	//3루타
					for(int r=1; r<3; r++) {
						if(roo[r]) {
							score++;
							roo[r] = false;
						}
					}
					roo[3] = true;	//3루에도 선수가 가게 됨
				} else if(now == 4) {	//홈런
					for(int r=1; r<=3; r++) {
						if(roo[r]) {	//주의!!(각 루에 사람이 있어야 점수를 낼 수있음)
							score++;
							roo[r] = false;
						}
					}
					score++;	//타자도 홈으로 가게 됨
				} else if(now == 0) {	//아웃
					out++;
					if(out == 3)	break;
				}
			}
		}//end for
		
		return score;
	}//end playGame()
}
