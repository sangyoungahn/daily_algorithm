/*
 * Combination
 * 1. idx ���� : �������� �������ִ� �����̴�. �츮�� Idx�� ���������� ��� ����, Idx������ ���� ���Ҵ� �Ĵٵ� ���� ���� ���̴�.
   2. cnt ���� : �츮�� ���� ���� ������ ������ �������ִ� �����̴�. ���� ���� ������ ������ �츮�� ���������� �̰��� �ϴ� ������ ������ ��ġ�Ѵٸ�, �� ���� ���μ����� �����ϸ� �ȴ�.
 */

public class Combination {
	static int[] arr = { 1, 2, 3, 4, 5 };
	static boolean[] visited = new boolean[arr.length]; // �ߺ��� ������� �ʱ� ������ �˻��ϴ� �뵵

	public static void main(String[] args) {
		// 5�� �߿� 3���� �̴� �� ����
		// DFS(�������� �������ִ� ����, �� ���� �̾ƾ� �ϴ���)
		dfs(0, 0);
	}

	public static void dfs(int idx, int cnt) {
		// 3���� �� �������� ���
		if (cnt == 3) {
			print();
			return;
		}

		// i ��� int�� ������ Idx��� ������ �����Ͽ��� 1�� �����ϸ鼭 Max���� �ݺ��մϴ�.
		// = i��° ���� ���� ������ �׳� ����������. �������� �ʾҴٸ� �����ߴٰ� ǥ�����ְ�, ���ȣ���� �ϰڽ��ϴ�.
		// = �׸��� �ٽ� �������� �ʾҴٰ� ǥ�����ٰԿ�.
		for (int i = idx; i < 5; i++) {
			if (visited[i]) // �̹� �湮�� idx�� �׳� ��������, for������ idx�� ����������
				continue;

			visited[i] = true;
			dfs(i, cnt + 1);
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
