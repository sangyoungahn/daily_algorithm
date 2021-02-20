/*
 * 1. idx 변수 : 시작점을 결정해주는 변수이다. 우리는 Idx를 시작점으로 삼는 순간, Idx이전에 나온 원소는 쳐다도 보지 않을 것이다.
   2. cnt 변수 : 우리가 현재 뽑은 원소의 갯수를 결정해주는 변수이다. 현재 뽑은 원소의 갯수가 우리가 최종적으로 뽑고자 하는 원소의 갯수와 일치한다면, 그 다음 프로세스를 진행하면 된다.
 */

public class Permutation1 {
	static int[] arr = new int[5];
	static boolean[] select = new boolean[5];	//중복을 허용하지 않기 때문에 검사하는 용도
	
	public static void main(String[] args) {
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		//5개 중에 3개를 뽑는 것 구현
		//DFS(시작점을 결정해주는 변수, 몇 개를 뽑아야 하는지)
		dfs(0,0);
	}

	public static void dfs(int idx, int cnt) {
		// 3개를 다 봅았으면 출력
		if(cnt==3) {
			print();
			return;
		}
		
		// i 라는 int형 변수는 Idx라는 값에서 시작하여서 1씩 증가하면서 Max까지 반복합니다.
		// = i번째 값을 선택 했으면 그냥 지나가세요. 선택하지 않았다면 선택했다고 표시해주고, 재귀호출을 하겠습니다.
		// = 그리고 다시 선택하지 않았다고 표시해줄게요.
		for(int i=idx; i<5; i++) {
			if(select[i] == true) continue;		//이미 방문한 idx면 그냥 지나가고, for문에서 idx를 증가시켜줌
			select[i] = true;
			
			dfs(i,cnt+1);
			select[i] = false;
		}
	}

	// 뽑은 원소들을 출력하는 함수
	public static void print() {
		for(int i= 0; i<5; i++) {
			if(select[i] == true) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

}
