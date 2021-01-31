package level3;

public class �ܾȯ_Soluton {
	static int minConversion;
	static boolean[] visited;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		minConversion = words.length;
		visited = new boolean[words.length];
		dfs(begin, target, 0, words);

		minConversion = (minConversion == words.length) ? 0 : minConversion;
		System.out.println(minConversion);

	}

	public static void dfs(String presentWord, String target, int count, String[] words) {
		// "���� �ܾ� = ��ǥ �ܾ�"�� ��� count�� Ƚ�� ��
		if (presentWord.equals(target)) {
			minConversion = (minConversion > count) ? count : minConversion;
			return;
		}

		// dfs Ž��
		for (int i = 0; i < words.length; i++) {
			// ���� �湮���� �ʾҰ�, ���ڰ� 1���� ���̳��ٸ� dfs Ž�� ����
			if (!visited[i] && check(presentWord, words[i])) {
				visited[i] = true;
				// persentWord�� words[i]�� �Ѱ��ִ� ����
				// : ���ǿ� �´� �ܾ ã�ұ� ������ ���۰��� ���ǿ� �´� �ܾ�� �ٲ��� -> ���ǿ� �´� �ܾ�� �ٽ� ��� Ž��
				dfs(words[i], target, count + 1, words);
				visited[i] = false;
			}
		}
	}

	public static boolean check(String presentWord, String nextWord) {
		int checkCnt = 0;

		// �ܾ� �ϳ��� üũ
		for (int i = 0; i < presentWord.length(); i++) {
			if (presentWord.charAt(i) != nextWord.charAt(i)) {
				checkCnt++;
			}
		}

		// �ܾ��� ���ڰ� �ٸ��� �� ���� true ��ȯ
		return checkCnt == 1 ? true : false;
	}

}
