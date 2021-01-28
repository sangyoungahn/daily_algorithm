package level3;

/*
 * 1. Ǯ�̽ð� : 1�ð� �ʰ�
 * 2. Ǯ�̹��
 *    Bottom-Up�� dp ������� ǰ
 *    1. ���ο� �迭�� �����ڸ����� ���� ���ؼ� �����س���
 *    2. �߰��� �ִ� ������ ���� ��ġ�� �� �� �ִ� �� 2�� �� �� ū ���� ��� ����
 *    3. ������ �迭�� ������ �࿡ �ִ� ���� �� ���� ū ���� ���
 * 3. ���� �ð����⵵ : O(n^2)
 */
public class ��� {
	public static void main(String[] args) {
		int[][] triangle = new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int answer = solution(triangle);

		System.out.println(answer);

	}

	public static int solution(int[][] triangle) {
		int[][] copy = new int[triangle.length][triangle.length];

		copy[0][0] = triangle[0][0];
		// �����ڸ��� ������ ���� ����
		for (int i = 1; i < triangle.length; i++) {
			copy[i][0] = copy[i - 1][0] + triangle[i][0];
			copy[i][i] = copy[i - 1][i - 1] + triangle[i][i];
		}

		// ���� �� ���� �� �� ū �Ͱ� ���� ���� ����(�߰��� �ִ� ����)
		for (int i = 2; i < triangle.length; i++) {
			for (int j = 1; j < i; j++) {
				copy[i][j] = Math.max(copy[i - 1][j - 1], copy[i - 1][j]) + triangle[i][j];
			}
		}

		int maxVal = copy[copy.length - 1][0];
		// ���� �Ʒ��� �ִ� ���� �� �ִ밪 ã��
		for (int i = 1; i < triangle.length; i++) {
			int targetVal = copy[copy.length - 1][i];
			if (targetVal > maxVal) {
				maxVal = targetVal;
			}
		}

		return maxVal;
	}

}
