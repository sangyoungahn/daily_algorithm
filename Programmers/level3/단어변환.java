package level3;

public class 단어변환_Soluton {
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
		// "나온 단어 = 목표 단어"일 경우 count와 횟수 비교
		if (presentWord.equals(target)) {
			minConversion = (minConversion > count) ? count : minConversion;
			return;
		}

		// dfs 탐색
		for (int i = 0; i < words.length; i++) {
			// 아직 방문하지 않았고, 글자가 1개만 차이난다면 dfs 탐색 시작
			if (!visited[i] && check(presentWord, words[i])) {
				visited[i] = true;
				// persentWord에 words[i]를 넘겨주는 이유
				// : 조건에 맞는 단어를 찾았기 때문에 시작값을 조건에 맞는 단어로 바꿔줌 -> 조건에 맞는 단어에서 다시 재귀 탐색
				dfs(words[i], target, count + 1, words);
				visited[i] = false;
			}
		}
	}

	public static boolean check(String presentWord, String nextWord) {
		int checkCnt = 0;

		// 단어 하나씩 체크
		for (int i = 0; i < presentWord.length(); i++) {
			if (presentWord.charAt(i) != nextWord.charAt(i)) {
				checkCnt++;
			}
		}

		// 단어의 문자가 다른게 한 개면 true 반환
		return checkCnt == 1 ? true : false;
	}

}
