package level3;
/*
 * 1. Ǯ�̽ð� : 1�ð� �ʰ�
 * 2. Ǯ�̹��
 *      1) ���� �� ���ڿ����� �˻��ϸ鼭 ���ڿ��� ���̸� �ϳ��� �ٿ�����
        2) ���ڿ��� ���� ��ġ�� �ϳ��� ������Ű�鼭 "������ ���ڿ��� ����"�� ���� ��ŭ ������ ��
        3) ���� �ʴٸ� ���ڿ��� ���̸� �ϳ��� ���̸鼭 �ݺ�
 * 3. ���� �ð����⵵ : O(n^3)
 */
public class ������Ӹ���� {

	public static void main(String[] args) {
		String s = "abacde";

		char[] charArray = s.toCharArray();

		// ���� �� ���ڿ����� �ϳ��� �ٿ����� �Ӹ���� �˻�
		for (int leng = s.length(); leng > 1; leng--) {
			// ���� ��ġ
			for (int start = 0; start + leng <= s.length(); start++) {
				boolean check = true;

				// ���� �ε������� ���ڿ� ������ ���ݸ�ŭ ���ڰ� ������ ��
				for (int i = 0; i < leng / 2; i++) {
					if (charArray[start + i] != charArray[start + leng - i - 1]) {
						check = false;	//�̰� �������� ������ ���� ����� �غ���
						break;
					}
				}

				// ���ݸ�ŭ ���ڰ� ���ٸ� �ش� ���ڿ��� ���̸� �ٷ� ���
				if (check)
					System.out.println(leng);
			}

		}

		System.out.println(1);
	}

}
