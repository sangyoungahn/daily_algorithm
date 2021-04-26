package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ����3_2_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");

		int N = Integer.parseInt(srr[0]);
		int M = Integer.parseInt(srr[1]);
		int K = Integer.parseInt(srr[2]);

		int[] nums = new int[N];
		srr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(srr[i]);
		}

		// �迭 �����ϰ�, ���� ū ��, �ι�°�� ū �� ��������
		Arrays.sort(nums);
		int first = nums[N - 1];
		int second = nums[N - 2];

		// ���� ū ���� �������� Ƚ�� ���
		int cnt = (M / (K + 1)) * K; // (K���� ���� ū �� + 1���� �ι�°�� ū ��)�� ������ Ƚ�� x ���� ū ���� ������ Ƚ��
										// ��� x ���� ū���� ������ Ƚ��
		cnt += (M % (K + 1)); // M�� �� ������ �������� ������, �ڿ� �����ִ� ���� ū�� ���� Ƚ������ �������

		int result = 0;
		result += cnt * first; // ���� ū �� ���ϱ�
		result += (M - cnt) * second; // �ι�°�� ū �� ���ϱ�
		
		System.out.println(result);
	}

}
