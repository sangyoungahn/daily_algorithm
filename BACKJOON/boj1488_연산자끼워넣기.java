package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 1. Ǯ�̽ð� : 
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * 	(1) �ּҰ� ���ϱ�
 * 		����ϸ鼭 ���� ��갪���� �� Ŀ���� ����(��Ʈ��ŷ)
 * 	(2) �ִ밪 ���ϱ�
 * 		
 */
public class boj1488_�����ڳ����ֱ� {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int[] operator = new int[4];
	static int[] number;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];

		// ���� �Է�
		String[] srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			number[i] = Integer.parseInt(srr[i]);
		}

		// ������ �Է� -> ������� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� ����
		srr = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(srr[i]);
		}

		dfs(number[0], 1);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}

	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			
			return;
		}

		// �����ϴ� �������� ������� Ž��
		for (int i = 0; i < 4; i++) {
			// �������� ������ 1�� �̻��� ���
			if (operator[i] > 0) {
				// �ش� �����ڸ� ����ϹǷ� 1 ���ҽ�Ŵ
				operator[i]--;

				// �������� ������ ���� ���� ���ڸ� ������, �E��, ������, �������� ������
				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1);
					break;
				case 1:
					dfs(num - number[idx], idx + 1);
					break;
				case 2:
					dfs(num * number[idx], idx + 1);
					break;
				case 3:
					dfs(num / number[idx], idx + 1);
					break;
				}
				
				// ���ȣ���� ����Ǹ� �ٽ� ������ ������ ������
				operator[i]++;
			}
		}
	}

}
