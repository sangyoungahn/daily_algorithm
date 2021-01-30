package level3;

/*
 * Ǯ�̽ð� : 50��
 * Ǯ�̹��
    1. �����̸� -1�� ǥ��
    2. ���� �� ����(����)�� "i = 0"�̹Ƿ�, "i != 0"�� ���� �Ʒ� ����(|)���� �����ֱ� ���� ��
       ���� ������(����)�� "j = 0"�̹Ƿ�, "j != 0"�� ���� ������ ����(->)���� �����ֱ� ���� ��
       ���� ���ٵ� �ƴϰ�, �����ٵ� �ƴ� ���, ������ ����� �Ʒ� �������� �� �� �����ְ� ��
       �ᱹ, ������ ��ġ�� �� �� �ִ� ��� ����� ���� ����
 * ���� �ð����⵵ : O(n^2)
 */
public class �ܾȯ {
	public static void main(String[] args) {
		int m = 4, n = 3;
		int[][] puddles = new int[][] { { 3, 2 }, { 2, 4 } };
		int answer = solution(m, n, puddles);

		System.out.println(answer);

	}

	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int[][] map = new int[n][m]; // i(����), j(����)

		map[0][0] = 1; // �ʱ�ȭ
		// �����̴� -1�� ó��
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}

		// ��� �� Ž���ϸ� �ش� ��ġ�� �� �� �ִ� �ִ�� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// �������� ��� 0���� �ٲ���(���Ҷ� �����ġ�� �ʱ� ����)
				if (map[i][j] == -1) {
					map[i][j] = 0;
					continue;
				}
				// �Ʒ� ����(|)���� �����ֱ� ���� ��
				if (i != 0) {
					map[i][j] += map[i - 1][j] % 1000000007;
				}
				// ������ ����(->)���� �����ֱ� ���� ��
				if (j != 0) {
					map[i][j] += map[i][j - 1] % 1000000007;
				}
			}
		}
		answer = map[n - 1][m - 1] % 1000000007;

		return answer;
	}
}
