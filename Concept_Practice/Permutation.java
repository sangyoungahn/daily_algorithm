import java.util.Arrays;

/*
 * Permutation
 * - temp �迭
 * ������ ������ ����ؾ��ϹǷ� �ӽ� �迭(temp)�� �ʿ� -> ����� ����ŭ�� �迭�� ũ�⸦ �������ָ� ��
 * �ӽ� �迭�� ���� vsited�� true�� ���� �ٷ� ����ع����� {2,3,1}�� {1,2,3}���� ��µǴ� ������ �߻�
 * 
 * - visited �迭
 * ��� ���� �� Ž���ؾ��ϹǷ� arr �迭�� ���̸�ŭ ũ�� ����
 * �̴� ����ŭ �迭�� ũ�⸦ �����ϸ� ��� ���̽��� �� ��µ��� ����
 */
public class Permutation {
	// 5�� �� 3���� �̱�
	static int[] arr = { 1, 2, 3, 4, 5 };
	static int[] temp = new int[3]; 
	static boolean[] visited = new boolean[arr.length];

	public static void main(String[] args) {
		dfs(0);
	}

	private static void dfs(int depth) {
		// arr.length���� ���� ������ �����ָ� ��
		if (depth == 3) {
			System.out.println(Arrays.toString(temp));
			return;
		}

		// ����
		for (int i = 0; i < arr.length; i++) {
			// �̹� �湮�� �ߴٸ� �����ϰ� �ε��� ����
			if (visited[i])
				continue;

			temp[depth] = arr[i]; // �ӽ� �迭�� ����� �� �ֱ�
			visited[i] = true;
			dfs(depth + 1);
			visited[i] = false;
		}

	}

	// ���� ���ҵ��� ����ϴ� �Լ�
	public static void print() {
		for (int i = 0; i < 5; i++) {
			if (visited[i] == true) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

}