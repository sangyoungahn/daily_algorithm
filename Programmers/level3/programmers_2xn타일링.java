package level3;
/*
 * 1. Ǯ�̽ð� : �ð��ʰ�
 * 2. ���� �ð����⵵ : O(N)
 * 3. Ǯ�̹��
 * 	- dp���� -> ��ȭ�� ã��
 *  - n = 1 -> ����� �� 1 / n = 2 -> ����� �� 2 / n = 3 -> ����� �� 3 / n = 4 -> ����� �� 5
 *    => dp[n] = dp[n-1] + dp[n-2]
 */	
public class programmers_2xnŸ�ϸ� {

	public static void main(String[] args) {
		int n = 4;
		int result = 0;
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 1000000007;
		}
		
		result = dp[n];
		System.out.println(result);
	}

}
