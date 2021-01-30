package level3;

/*
 * 풀이시간 : 50분
 * 풀이방법
    1. 웅덩이를 -1로 표시
    2. 가장 맨 윗줄(가로)만 "i = 0"이므로, "i != 0"일 때는 아래 방향(|)으로 더해주기 위한 것
       가장 왼쪽줄(세로)만 "j = 0"이므로, "j != 0"일 때는 오른쪽 방향(->)으로 더해주기 위한 것
       가장 윗줄도 아니고, 왼쪽줄도 아닐 경우, 오른쪽 방향과 아래 방향으로 두 번 더해주게 됨
       결국, 각각의 위치에 갈 수 있는 모든 경우의 수가 저장
 * 예상 시간복잡도 : O(n^2)
 */
public class 단어변환 {
	public static void main(String[] args) {
		int m = 4, n = 3;
		int[][] puddles = new int[][] { { 3, 2 }, { 2, 4 } };
		int answer = solution(m, n, puddles);

		System.out.println(answer);

	}

	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int[][] map = new int[n][m]; // i(세로), j(가로)

		map[0][0] = 1; // 초기화
		// 웅덩이는 -1로 처리
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}

		// 모든 맵 탐색하며 해당 위치에 갈 수 있는 최대수 구함
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 웅덩이일 경우 0으로 바꿔줌(더할때 영향미치기 않기 위해)
				if (map[i][j] == -1) {
					map[i][j] = 0;
					continue;
				}
				// 아래 방향(|)으로 더해주기 위한 것
				if (i != 0) {
					map[i][j] += map[i - 1][j] % 1000000007;
				}
				// 오른쪽 방향(->)으로 더해주기 위한 것
				if (j != 0) {
					map[i][j] += map[i][j - 1] % 1000000007;
				}
			}
		}
		answer = map[n - 1][m - 1] % 1000000007;

		return answer;
	}
}
