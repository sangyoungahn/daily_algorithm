package day02.sw5215;

import java.util.Scanner;
import java.io.FileInputStream;

//재료 저장하는 클래스
class item {
	int score;
	int cal;

	public item() {	}

	public item(int score, int cal) {
		this.score = score;
		this.cal = cal;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCal() {
		return cal;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}

}

public class SW5215_햄버거다이어트 {
	private static int N, L, max;
	private static item[] items;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();	//재료의 수
			L = sc.nextInt();	//제한 칼로리
			max = 0;

			items = new item[N];

			for (int i = 0; i < N; i++) {
				items[i] = new item();

				//값 입력 받음
				int score = sc.nextInt();
				int cal = sc.nextInt();

				//점수, 칼로리 값을 items 배열에 넣음
				items[i].setScore(score);
				items[i].setCal(cal);
			}

			dfs(0, 0, 0);	//dfs(depth, score, cal)
			System.out.println("#" + t + " " + max);
		}
	}

	// dfs 알고리즘을 통해 item 조합의 최고점을 찾는 알고리즘
	public static void dfs(int depth, int score, int cal) {
		
		//칼로리가 제한 칼로리보다 높으면 종료
		if(cal>L)
			return;

		// N번째까지 확인했으면
		if (depth == N) {
			if (cal <= L)	//?????
				if (max < score)
					max = score;
				else
					return;

		} else {
			// 해당 재료 넣기(depth번째의)
			dfs(depth + 1, score + items[depth].score, cal + items[depth].cal);

			// 해당 재료 빼기?????
			dfs(depth + 1, score, cal);

		}

		return;
	}

	//최대값을 계속 저장해주는 함수
	public static int max(int a, int b) {
		if(a > b)
			return a;
		else
			return b;
	}
}