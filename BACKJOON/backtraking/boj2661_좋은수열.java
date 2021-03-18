package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2661_�������� {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		backtraking("");
	}

	private static void backtraking(String result) {
		if(result.length() == N) {
			System.out.println(result);
			System.exit(0);	//���� �����ϰ� �ִ� ���μ����� ���� ����
		} else {
			for(int i=1; i<=3; i++) {
				if(isGoodSequence(result + i)) {
					//���ۼ����̸�(= ������ ������ ������ �ִٸ�) ��� ���̸� �ø��鼭 Ž�� -> ���� ������ ã�ƾ��ϹǷ�
					backtraking(result + i);
				}
			}
		}
	}

	private static boolean isGoodSequence(String s) {
		int length = s.length() / 2;
		
		for(int i=1; i<=length; i++) {
			if(s.substring(s.length()-i).equals(s.substring(s.length()-(2*i), s.length()-i))) {
				return false;
			}
		}
		
		return true;
	}

}
