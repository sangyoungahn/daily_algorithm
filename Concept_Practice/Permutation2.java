import java.util.Arrays;

public class Permutation2 {
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

		//����
		for (int i = 0; i < arr.length; i++) {
			//�̹� �湮�� �ߴٸ� ���� �ö󰡼� i����
			if(visited[i])	continue;
			
			//�湮�� �� �ߴٸ� �Ʒ��� �ڵ带 ����
			visited[i] = true;
			
			//�ӽ� �迭�� ����� �� �ֱ�
			temp[depth] = i+1;
			dfs(depth + 1);
			
			visited[i] = false;
		}
		
	}

}