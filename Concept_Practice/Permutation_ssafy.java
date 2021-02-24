import java.util.Arrays;

/*
 * Permutation (���ǿ��� �ߴ� ��) - 5�� �� 3���� ������ ���� �� ���� 0���� ��µȴ� ���� �߻�
 * ������ ����ؾ��ϹǷ� temp �ӽ� �迭�� �ʿ�
 * �ӽ� �迭�� ���� vsited�� true�� ���� �ٷ� ����ع����� {2,3,1}�� {1,2,3}���� ��µǴ� ������ �߻�
 */
public class Permutation_ssafy {
	static int[] arr = { 1, 2, 3 };
	static boolean[] visited = new boolean[arr.length];
	static int[] temp = new int[arr.length]; // ������ ������ ����ؾ��ϱ� ������ temp �ӽ� �迭�� �ʿ�

	public static void main(String[] args) {
		dfs(0);
	}

	private static void dfs(int depth) {
		// arr.length���� ���� ������ �����ָ� ��
		if (depth == arr.length) {
			System.out.println(Arrays.toString(temp));
			return;
		}

		// ����
		for (int i = 0; i < arr.length; i++) {
			// �̹� �湮�� �ߴٸ� �����ϰ� �ε��� ����
			if (visited[i])
				continue;

			visited[i] = true;
			temp[depth] = arr[i]; // �ӽ� �迭�� ����� �� �ֱ�
			dfs(depth + 1);
			visited[i] = false;
		}

	}

}