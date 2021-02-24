import java.util.Arrays;

/*
 * Permutation (싸피에서 했던 것) - 5개 중 3개를 뽑으면 끝에 빈 곳은 0으로 출력된느 문제 발생
 * 순서를 고려해야하므로 temp 임시 배열이 필요
 * 임시 배열이 없이 vsited가 true인 것을 바로 출력해버리면 {2,3,1}도 {1,2,3}으로 출력되는 문제가 발생
 */
public class Permutation_ssafy {
	static int[] arr = { 1, 2, 3 };
	static boolean[] visited = new boolean[arr.length];
	static int[] temp = new int[arr.length]; // 순열은 순서를 고려해야하기 때문에 temp 임시 배열이 필요

	public static void main(String[] args) {
		dfs(0);
	}

	private static void dfs(int depth) {
		// arr.length에는 뽑을 개수를 적어주면 됨
		if (depth == arr.length) {
			System.out.println(Arrays.toString(temp));
			return;
		}

		// 순열
		for (int i = 0; i < arr.length; i++) {
			// 이미 방문을 했다면 무시하고 인덱스 증가
			if (visited[i])
				continue;

			visited[i] = true;
			temp[depth] = arr[i]; // 임시 배열에 출력할 값 넣기
			dfs(depth + 1);
			visited[i] = false;
		}

	}

}