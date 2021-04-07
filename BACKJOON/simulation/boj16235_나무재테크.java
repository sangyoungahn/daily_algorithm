

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class boj16235_나무재테크2 {
	static int[] di = {-1,-1,-1,0,1,1,1,0};
	static int[] dj = {-1,0,1,1,1,0,-1,-1};
	static int[][] map;
	static int[][] A;
	
	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;
		int life;	//죽었는지 살았는지(1-살음, 0-죽음)
		
		public Tree(int x, int y, int age, int life)  {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
			this.life = life;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + ", life=" + life + "]";
		}

		//age 기준으로 오름차순으로 정렬
		@Override
		public int compareTo(Tree t) {
			return Integer.compare(age, t.age);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);	//A배열의 크기
		int M = Integer.parseInt(srr[1]);	//추가된 나무의 개수
		int K = Integer.parseInt(srr[2]);	//K년 지난후
		
//		//나무를 집어넣을 때부터 앞에서부터 넣자 -> sort가 필요없음
//		LinkedList<String> list = new LinkedList<>();
//		list.add(0,"ddd");	//0의 인덱스에 ddd를 넣음
		
		map = new int[N][N];	//초기화 된 양분 밭
		A = new int[N][N];	//양분 밭
		for(int i=0; i<N; i++) {	//양분밭은 1부터 시작하지만 시작을 0으로 고치고 나무위치를 받을 때 +1하지 않고 받으면 됨(인덱스 맞추기)
			srr = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(srr[j]);	//A배열의 값 입력(양분밭 - 겨울에 추가할 값 양분들)
				map[i][j] = 5;	//초기 양분밭 - 5초 초기화
			}
		}
//		//output test
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(A[i][j]);
//			}
//			System.out.println();
//		}
		
		LinkedList<Tree> treeList = new LinkedList<>();	//심은 나무를 저장할 LinkedList
		//treeList 값 저장 - 상도가 심은 나무의 정보
		for(int i=0; i<M; i++) {
			srr = br.readLine().split(" ");
			int x = Integer.parseInt(srr[0]);
			int y = Integer.parseInt(srr[1]);
			int age = Integer.parseInt(srr[2]);

			treeList.add(new Tree(x-1,y-1,age,1));	//양분밭과 인덱스 맞추기
		}
		Collections.sort(treeList);			//treeList의 나무들을 나이라 작은 순서로 정렬함
		
//		//Tree출력 테스트
//		for(Tree t : treeList) {
//			System.out.println(t);
//		}
		
//		//treeList 정렬해주기(나이순으로 양분을 먹어야하므로)
//		Iterator<Tree> it = treeList.iterator();
//		while(it.hasNext())
//		{
//			Tree n = it.next();
//			System.out.println(n.age);
//		}
		
//		//sort output test
//		for(int i=0; i<treeList.size(); i++) {
//			System.out.println(treeList.get(i).age);
//		}

		//년도만큼 반복
		for(int k=0; k<K; k++) {
			//가을에 번식하는 나무들을 저장하기 위한 새로운 Tree 리스트
			LinkedList<Tree> newTreeList = new LinkedList<>();
			
			//봄
			for(Tree t : treeList) {
				if(map[t.x][t.y] >= t.age) {
					map[t.x][t.y] -= t.age;
					t.age++;
				}else {
					t.life=0;	//죽음
				}
			}
			//여름
			LinkedList<Tree> tempList = new LinkedList<>();	//죽은 나무들을 저장하는 리스트(죽은 나무들은 번식하면 안되므로)
			for(Tree t : treeList) {
				if(t.life==0) {
					map[t.x][t.y] += t.age/2;
					tempList.add(t);
				}
			}
//			System.out.println("죽은 나무 삭제하기 전 treeList 사이즈 : " + treeList.size());
//			System.out.println("죽은 나무를 넣은 list 사이즈 : " + tempList.size());
			treeList.removeAll(tempList);	//죽은 나무들을 기존의 나무 list에서 빼줌(시간초과 때문에 해주는 것)
//			System.out.println("죽은 나무 삭제 후 treeList 사이즈 : " + treeList.size());
//			System.out.println("=================================================");
			
			//가을
			Iterator<Tree> it = treeList.iterator();
			Tree temp;
			while(it.hasNext()) {
				temp = it.next();
				if(temp.age%5==0 && temp.life==1) {	//t.lift==1 주의!!(죽으면 번식 못함)
					for(int j =0; j<8; j++) {
						int ti = temp.x + di[j];
						int tj = temp.y + dj[j];
						
						if(ti<0 || ti>=N || tj<0 || tj>=N)	continue;
						newTreeList.add(new Tree(ti, tj, 1, 1));
						
					}
				}
			}
			treeList.addAll(0, newTreeList);	//가을에 새로 생성된 tree들을 기존의 tree리스트에 넣어야 함
			
			//겨울
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] += A[i][j];
				}
			}
		}//봄,여름,가을,겨울
		
		int cnt=0;	//살아있는 나무의 개수
		for(Tree t : treeList) {
			if(t.life!=0)	cnt++;
		}
		System.out.println(cnt);
	}

}
