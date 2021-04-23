package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. Ǯ�̽ð� : 15��
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * 	(1) �����Ҵ� ������ ������ ���� ���� ���� �̾Ƴ�
 * 	(2) ������ ������ ������ ���� ���� ���� ��� -> ���� ������ ���� x �ش� �������� ������ ����
 * 	(3) ������ ������ ������ ���� ���� ���� �ƴ� ���
 * 		-> ������ ���� ���� ���� ����, �� ���� ������ ���� ������ ������ ���̸� ������
 * 	�ᱹ, ���� ���ݰ� ���� ������ ���ϴ� ������ �ʿ�
 */
public class boj13305_������_MySol {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] distArr = new int[N - 1];
		int[] priceArr = new int[N];
		int minCost = 0;
		int sumLoad = 0;
		int tempSum = 0;
		int sum = 0;

		// ������ ���� �Է�
		String[] srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			distArr[i] = Integer.parseInt(srr[i]);
		}

		// �������� ���ʹ� ���� �Է�
		srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			priceArr[i] = Integer.parseInt(srr[i]);
		}

		minCost = priceArr[0];	//5
		sumLoad = 0;
		// ���� ���ݰ� ���� ������ ���ϴ� ����
		for (int i = 0; i < priceArr.length-1; i++) {
			// "minCost <= ���� ������ ����" ������ �����ؾ� ������ ���̸� ���� �� ����
			if (minCost <= priceArr[i]) {
				System.out.println("minCost(" + minCost + ") <= ���� ������ ����(" + priceArr[i] + ")");
				System.out.println("minCost : " + minCost);
				System.out.println("road[" + i + "] : " + distArr[i]);
				sumLoad += distArr[i];
				System.out.println("sumLoad : " + sumLoad);

				// ������ �ε����� ��� ���ϱ�
				if (i == priceArr.length - 2) {
					System.out.println("������ �ε���");
					tempSum = sumLoad * minCost;
				}
			}
			// "���� ������ ���� > minCost"�� ��� -> ���� �������� minCost�� ����, ���� ������ ���� �ʱ�ȭ
			else {
				System.out.println("���� ������ ����(" + priceArr[i] + ") > minCost(" + minCost + ")");
				tempSum = sumLoad * minCost;
				System.out.println("tempSum : " + tempSum);
				minCost = priceArr[i];
				System.out.println("minCost : " + minCost);
				sumLoad = 0;
			}
			sum += tempSum;
		}
		
		System.out.println(sum);
	}

}
