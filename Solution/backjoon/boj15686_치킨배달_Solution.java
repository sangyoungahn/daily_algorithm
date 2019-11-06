package day01;
import java.util.ArrayList;
import java.util.Scanner;


public class Main_BOJ_15686_치킨배달 {

	static int[][] map;
	static int N; // 배열 사이즈
	static int M; // 치킨집 갯수
	static ArrayList<Loc> houses;
	static ArrayList<Loc> chikens;
	static boolean[] v;
	static int[] selections;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map  = new int[N][N];
		houses = new ArrayList<Loc>();
		chikens = new ArrayList<Loc>();
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {  // 집이면 집리스트에 추가
					houses.add(new Loc(i,j));
				}else if(map[i][j] == 2) {
					chikens.add(new Loc(i,j));  // 치킨집 목록에 추가
				}
			}
		}
		// 방문체크 배열(선택함, 선택안함)
		v = new boolean[chikens.size()];
		selections = new int[chikens.size()];
		
//		dfs(0,0);  // 선택 정점을 처음부터 하면 중간값 먼저 선택한 경우가 되지 않음 예제 입력 3번		
		for(int i =0 ; i < chikens.size(); i++) {
			v[i] = true;
			dfs(i,0);
			v[i] = false;
		}
		
		System.out.println(result);
		
	}
	static void dfs(int start, int depth) {
		//★★power set 선택하는 부분(암기)
		selections[depth] = start;
		for(int i = start; i < chikens.size(); i++) {
			//방문했으면 넘어가기
			if(v[i]) {
				continue;
			}
			v[i] = true;
			dfs(i, depth + 1);
			v[i] = false;
		}
		
		//선택한 개수가 됬을 때 거리 계산
		if(depth == M-1) {
			int sum = 0;
			int cDist = 0;
			for(int i = 0 ; i < houses.size(); i++) {	//집 선택(집을 기준으로 여러개의 치킨집의 거리를 계산)
				int cMin = Integer.MAX_VALUE;
				for(int j =0; j < M; j++) {		//치킨집 선택
					cDist = calc(houses.get(i), chikens.get(selections[j]));
					cMin = Math.min(cMin, cDist);
				}
				sum += cMin;	//집을 기준으로 떨어진 모든 치킨집의 거리를 다 더함
			}
			result = Math.min(result, sum);
			return;
		}
	}
	static int calc(Loc x1, Loc x2) {
		return Math.abs(x1.x-x2.x) + Math.abs(x1.y - x2.y);
	}
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}