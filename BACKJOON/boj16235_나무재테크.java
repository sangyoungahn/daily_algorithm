

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class boj16235_나무재테크 {
	static class Tree {
		int x;
		int y;
		int age;
		int life;	//죽었는지 살았는지
		
		public Tree(int x, int y, int age, int life) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
			this.life = life;
		}
	}
	
	static int[] di = {-1,-1,-1,0,1,1,1,0};
	static int[] dj = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);	//A배열의 크기
		int M = Integer.parseInt(srr[1]);	//추가된 나무의 개수
		int K = Integer.parseInt(srr[2]);	//K년 지난후
		
//		//나무를 집어넣을 때부터 앞에서부터 넣자 -> sort가 필요없음
//		LinkedList<String> list = new LinkedList<>();
//		list.add(0,"ddd");	//0의 인덱스에 ddd를 넣음
		
		LinkedList<Tree> treeList = new LinkedList<>();	//심은 나무를 저장할 LinkedList
		int[][] map = new int[N][N];	//A배열
		//가장 처음 양분은 5초 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = 5;
			}
		}
		
		//A배열의 값 입력(겨울에 추가할 값들)
		int[][] A = new int[N][N];
		for(int i=0; i<N; i++) {
			srr = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(srr[j]);
			}
		}
		//output test
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
		
		//상도가 심은 나무의 정보
		for(int i=0; i<M; i++) {
			srr = br.readLine().split(" ");
			int x = Integer.parseInt(srr[0]);
			int y = Integer.parseInt(srr[1]);
			int age = Integer.parseInt(srr[0]);

			treeList.add(new Tree(x-1,y-1,age,1));
		}
		
		for(int i=0; i<K; i++) {
			//봄
			LinkedList<Tree> newTreeList = new LinkedList<>();
			
		}
	}

}
