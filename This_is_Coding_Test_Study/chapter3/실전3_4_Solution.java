package chapter3;

import java.util.Scanner;
/*
 * �ִ��� ���� ������ -> �׸��� �˰���
 */
public class ����3_4_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // N, K�� ������ �������� �����Ͽ� �Է� �ޱ�
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N�� K�� ������ �������� ���� �� �������� 1�� ����
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // N�� K���� ���� �� (�� �̻� ���� �� ���� ��) �ݺ��� Ż��
            if (n < k) break;
            // K�� ������
            result += 1;
            n /= k;
        }

        // ���������� ���� ���� ���Ͽ� 1�� ����
        result += (n - 1);
        System.out.println(result);
	}

}
