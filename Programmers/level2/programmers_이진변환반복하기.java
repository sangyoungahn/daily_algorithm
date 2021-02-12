package level2;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 1. Ǯ�̽ð� : �ð��ʰ�
 * 2. Ǯ�̹��
     before = [1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1]
     before ����Ʈ �ϳ��ϳ��� Ž���ϸ� after��� ���ο� ����Ʈ�� 1�� �־���
     after = [1, 1, 1, 1, 1, 1]
     ���ŵ� 0�� ���� = before�� ũ�� - after�� ũ��    -> removeZeroCnt�� ����
     
     after ����Ʈ�� ũ�⸦ �������� ���� ��ȯ �˰����� ���� binary ����Ʈ�� �־���
     binary ����Ʈ�� �Ųٷ� �������Ƿ� reverse�� ��
     ���� ��ȯ Ƚ�� 1����   -> toBinaryCnt ����
     
     ���� ��ȯ ����� ����� 1���� -> �ݺ��� ����
     1���� �ƴϸ� -> binary ����Ʈ�� �ִ� �͵��� before ����Ʈ�� �־ �ٽ� ������ ���� �ݺ�
 * 3. ���� �ð����⵵ : O(n)
 */
public class programmers_������ȯ�ݺ��ϱ� {

	public static void main(String[] args) {
		String s = "110010101001";
		char[] charArr = s.toCharArray();
		ArrayList<Character> before = new ArrayList<Character>();
		ArrayList<Character> after = new ArrayList<Character>();
		int toBinaryCnt = 0;
		int removeZeroCnt = 0;

		// ���� �ϳ��ϳ��� list�� �ֱ�
		for (int i = 0; i < charArr.length; i++) {
			before.add(charArr[i]);
		}

		while (true) {
			after.clear();
			// before�� Ž���ϸ� 1�̸� ���ο� ����Ʈ after�� �־���
			for (int i = 0; i < before.size(); i++) {
				if (before.get(i) == '1') {
					after.add('1');
				}
			}
			// ���ŵ� 0�� ���� ���ϱ�
			removeZeroCnt += before.size() - after.size();

			// 0�� ������ list�� ���̸� ���������� ǥ��
			ArrayList<Integer> binary = new ArrayList<Integer>();
			int mok = 0, nmg = 0;
			int num = after.size(); // 0 ���� �� �迭 ����
			do {
				mok = (int) num / 2;
				nmg = num - (mok * 2);

				// int -> char �ٲ㼭 ����
				binary.add(nmg);
				num = mok;
			} while (mok != 0); // mok�� 0�϶����� ���
			Collections.reverse(binary);
			toBinaryCnt++;

			// ���ڸ� ���ڸ� ����
			if (binary.size() == 1) {
				System.out.println("Ž�� ����");
				break;
			}
			// ���ڸ� ���ڰ� �ƴ� ��� �Ȱ��� ���� �ݺ�
			else {
				// ���� ������� ó�� ������ before ����Ʈ�� ����
				before.clear();
				for (int i = 0; i < binary.size(); i++) {
					before.add((char) (binary.get(i) + '0'));
				}
			}
		}

		System.out.println("���� ��ȯ�� Ƚ�� : " + toBinaryCnt);
		System.out.println("���ŵ� 0�� ���� : " + removeZeroCnt);
	}

}
