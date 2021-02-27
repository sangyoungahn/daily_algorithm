package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1. Ǯ�̽ð� : 
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * N�� 10^5���� �ɼ��ִٰ� �����Ƿ�, N x N�� �ϸ� �뷫 10��� Ž���� �ؾ��� -> �޸� �ʰ�
 * ���� �̺�Ž���� ��� -> Ž�� ������ ���ݾ� �ٿ� ������ ������ �ð� ���⵵ = O(logN)
 * 1	2	3
 * 2	4	6
 * 3	6	9	-> ���⼭ 4�� �������� �������� ��, �� ��°�� ������?
 * 					�̷� �� ���� ���� : cnt = min(mid/i, N)
 * 								-> mid : ������ ��, i : i��° ��
 * (1) left=1, right=k�� �ΰ�, left <= right�� ������ while���� ����
 * (2) �� �Ŀ� ���� cnt�� ���
 * (3) cnt�� k�� ���ϸ鼭 left Ȥ�� right�� �ʱ�ȭ
 */
public class boj1300_K��°�� {
	static int N, k, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = k;
		
		System.out.println(biSearch(left, right));
	}

	public static int biSearch(int left, int right) {
		int cnt = 0;
		int mid = (left + right) / 2;
		if(left > right)	return res;
		
		// mid���� �۰ų� ���� ���� �� ������ ���
		for(int i=1; i<=N; i++) {
			cnt += Math.min(mid/i, N);
		}
		
		// ���Ϸ��� �ϴ� ���� ����(k)�� cnt���� ������ -> mid ���� �� ū �������� ã�ƾ� ��
		// ���Ϸ��� �ϴ� ���� ����(k)�� cnt���� ũ�� -> mid ���� �� ���� �������� ã�ƾ� ��
		if(k<=cnt) {
			res = mid;
			return biSearch(left, mid-1);
		} else {
			return biSearch(mid+1, right);
		}
	}

}
