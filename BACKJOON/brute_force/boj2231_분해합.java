package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. Ǯ�̽ð� : 
 * 2. ���� �ð����⵵ : O()
 * 3. Ǯ�̹��
 * 
 */

public class boj2231_������ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		// 1~N���� �ݺ� -> ��� ��� Ž��
		for(int i=0; i<N; i++) {
			int number = i;
			int sum = 0;	//�� �ڸ��� ��
			
			while(number != 0) {
				sum += number % 10;	// �� �ڸ��� ���ϱ�
				number /= 10;
			}
			
			if(i + sum == N) {	// "������ ���� + �� �ڸ��� ������ = ������"�� ��� �����ڸ� ã�� ��
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
