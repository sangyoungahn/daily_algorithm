import java.util.Arrays;

public class Permutation {
	static boolean[] visited;
	static int[] arr = { 1, 2, 3 };
	static int[] temp = new int[arr.length];

	public static void main(String[] args) {
		visited = new boolean[3];
		dfs(0);
	}

	private static void dfs(int depth) {
		if (depth == arr.length) {
			System.out.println(Arrays.toString(temp));
			return;
		}

		//순열
		for (int i = 0; i < arr.length; i++) {
			//이미 방문을 했다면 위로 올라가서 i증가
			if(visited[i])	continue;
			
			//방문을 안 했다면 아래의 코드를 실행
			visited[i] = true;
			
			//임시 배열에 출력할 값 넣기
			temp[depth] = i+1;
			dfs(depth + 1);
			
			visited[i] = false;
		}
		
	}

}
