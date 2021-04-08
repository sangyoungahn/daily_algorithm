package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2941_ũ�ξ�Ƽ�ƾ��ĺ�_sol {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		int arrLength = charArr.length;
		int cnt = 0; // ���ĺ� ī��Ʈ

//		System.out.println("����!!!");
//		System.out.println("�迭 ũ�� : " + arrLength);

		int i; // �迭 �ڸ��� ��Ÿ���� �ε���
		for (i = 0; i < arrLength; i++) {
			cnt++;
			switch (charArr[i]) {
				case 'c':
					if (i<arrLength-1 && (charArr[i+1] == '=' || charArr[i+1] == '-')) {
						i++;
					}
					break;
				case 'd':
					if (i<arrLength-2 && charArr[i+1] == 'z' && charArr[i+2] == '=') {
						i+=2;
					}else if(i<arrLength-1 && charArr[i+1] == '-') {
						i++;
					}
					break;
				case 'l':
				case 'n':
					if(i<arrLength-1 && charArr[i+1] =='j') {
						i++;
					}
					break;
				case 's':
				case 'z':
					if(i<arrLength-1 && charArr[i+1] =='=') {
						i++;
					}
					break;
			}
		}

		System.out.println(cnt);
	}
}
