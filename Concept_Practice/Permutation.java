import java.util.Arrays;

/*
 * Permutation
 * - temp 배열
 * 순열은 순서를 고려해야하므로 임시 배열(temp)이 필요 -> 출력할 수만큼의 배열의 크기를 지정해주면 됨
 * 임시 배열이 없이 vsited가 true인 것을 바로 출력해버리면 {2,3,1}도 {1,2,3}으로 출력되는 문제가 발생
 * 
 * - visited 배열
 * 모든 수를 다 탐색해야하므로 arr 배열의 길이만큼 크기 지정
 * 뽑는 수만큼 배열의 크기를 지정하면 모든 케이스가 다 출력되지 않음
 */
public class Permutation {
	// 5개 중 3개만 뽑기
	static int[] arr = { 1, 2, 3, 4, 5 };
	static int[] temp = new int[3]; 
	static boolean[] visited = new boolean[arr.length];

	public static void main(String[] args) {
		dfs(0);
	}

	private static void dfs(int depth) {
		// arr.length에는 뽑을 개수를 적어주면 됨
		if (depth == 3) {
			System.out.println(Arrays.toString(temp));
			return;
		}

		// 순열
		for (int i = 0; i < arr.length; i++) {
			// 이미 방문을 했다면 무시하고 인덱스 증가
			if (visited[i])
				continue;

			temp[depth] = arr[i]; // 임시 배열에 출력할 값 넣기
			visited[i] = true;
			dfs(depth + 1);
			visited[i] = false;
		}

	}

	// 뽑은 원소들을 출력하는 함수
	public static void print() {
		for (int i = 0; i < 5; i++) {
			if (visited[i] == true) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

}