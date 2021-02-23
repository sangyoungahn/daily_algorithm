package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. Ǯ�̽ð� : 
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * 	(1) �����Ҵ� ������ ������ ���� ���� ���� �̾Ƴ�
 * 	(2) ������ ������ ������ ���� ���� ���� ��� -> ���� ������ ���� x �ش� �������� ������ ����
 * 	(3) ������ ������ ������ ���� ���� ���� �ƴ� ���
 * 		-> ���� ���� ���� ���� ����, �� ���� ������ ���� ������ ������ ���̸� ������
 * 	�ᱹ, ���� ���ݰ� ���� ������ ���ϴ� ������ �ʿ�
 */
public class boj13305_������ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] road = new int[N - 1];
		int[] cost = new int[N];
		int minCost = 0;
		int sumLoad = 0;
		int tempSum = 0;
		int sum = 0;

		// ������ ���� �Է�
		String[] srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			road[i] = Integer.parseInt(srr[i]);
		}

		// �������� ���ʹ� ���� �Է�
		srr = br.readLine().split(" ");
		for (int i = 0; i < srr.length; i++) {
			cost[i] = Integer.parseInt(srr[i]);
		}

		minCost = cost[0];
		sumLoad = road[0];
		// ���� ���ݰ� ���� ������ ���ϴ� ����
		for (int i = 1; i < cost.length; i++) {
			// "���� ������ ���� <= ���� ������ ����" ������ �����ؾ� ������ ���̸� ���� �� ����
			if (minCost <= cost[i]) {
				System.out.println("���� ������ ���� < ���� ������ ����");
				System.out.println("minCost : " + minCost);
				System.out.println("road[" + (i-1) + "] : " + road[i-1]);
				sumLoad += road[i-1];
				System.out.println("sumLoad : " + sumLoad);

				// ������ �ε����� ��� ���ϱ�
				if (i == cost.length - 2) {
					System.out.println("������ �ε���");
					tempSum = sumLoad * minCost;
				}
			}
			// "���� ������ ���� > ���� ������ ����"�� ��� -> ���� �������� minCost�� ����, ���� ������ ���� �ʱ�ȭ
			else {
				System.out.println("���� ������ ���� > ���� ������ ����");
				tempSum = sumLoad * minCost;
				System.out.println("tempSum : " + tempSum);
				minCost = cost[i];
				System.out.println("minCost : " + minCost);
				sumLoad = 0;
			}
			sum += tempSum;
		}
		
		System.out.println(sum);
	}

}
