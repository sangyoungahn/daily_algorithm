package chapter3;

import java.util.Scanner;

public class ����3_3_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // N, M�� ������ �������� �����Ͽ� �Է� �ޱ�
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        // �� �پ� �Է� �޾� Ȯ���ϱ�
        for (int i = 0; i < n; i++) {
            // ���� �ٿ��� '���� ���� ��' ã��
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '���� ���� ��'�� �߿��� ���� ū �� ã��
            result = Math.max(result, min_value);
        }

        System.out.println(result); // ���� ��� ���
	}

}
