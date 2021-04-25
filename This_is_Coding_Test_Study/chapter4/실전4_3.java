package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����4_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int row = input.charAt(1) - '0';		// 49 - 48 = 1(�ƽ�Ű�ڵ� ����ؼ� ���� �����)
		int col = input.charAt(0) - 'a' + 1;	// 97('a'�ƽ�Ű�ڵ�) - 97('a'�ƽ�Ű�ڵ�) + 1 = 1
		
		// ����Ʈ�� �̵��� �� �ִ� 8���� ����
		int[] di = {-1,-1,-2,-2,1,1,2,2};
		int[] dj = {-2,2,-1,1,-2,2,-1,1};
		
		// 8���� ���⿡ ���� �� ��ġ�� �̵��������� Ȯ��
		int cnt = 0;
		for(int dir=0; dir<8; dir++) {
			int ni = row + di[dir];
			int nj = col + dj[dir];
			
			// �ش� ��ġ�� �̵� �����ϸ� ī��Ʈ ����
			if(ni>=1 && ni<=8 && nj>=1 && nj<=8) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
