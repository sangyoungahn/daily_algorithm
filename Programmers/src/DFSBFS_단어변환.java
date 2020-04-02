package programmers;

public class DFSBFS_단어변환_Sol {
	static int minConversion = 0;
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		boolean[] visited = new boolean[words.length];
		dfs(begin, target, words, 0, visited);
		
		System.out.println(minConversion);
	}

	private static void dfs(String begin, String target, String[] words, int conversion, boolean[] visited) {
		if(begin.equals(target))
			//minConversion = 0 이라는 것는 minConversion이 초기값이라는 뜻임
			minConversion = (minConversion == 0) ? conversion : Math.min(minConversion, conversion);
		for(int i=0; i<words.length; i++) {
			//시작 단어와 같은 단어가 있다면 다음 것부터 다시 탐색
			if(begin.equals(words[i]))	continue;
			if(!visited[i] && hasOneCharDif(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, conversion+1, visited);
				visited[i] = false;
			}
		}
		return;
	}

	private static boolean hasOneCharDif(String str1, String str2) {
		int len = str1.length();
		int cnt = 0;
		for(int i=0; i<len; i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				cnt++;
				//같지 않은 문자가 2개 이상이면 cnt를 초기화시키고 반복문을 바져나감
				if(cnt>1) {
					//반복문을 빠져나갔을 때, "cnt==1"의 조건에 안 걸리기 위해서 -> false 리턴
					cnt = 0;
					break;
				}
			}
		}
		if(cnt == 1)	return true;
		return false;
	}
}
