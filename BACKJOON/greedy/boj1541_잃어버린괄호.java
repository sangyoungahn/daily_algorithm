package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj1541_�Ҿ������ȣ {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split("\\-");
		int sum = add(srr[0]);
		
		for(int i=1; i<srr.length; i++) {
			//add() �Լ��� ȣ���ϰ� ���� -�� ���� ��� ���ڵ��� ���� �������� ���ϵ�
			sum -= add(srr[i]);
		}
		
		System.out.println(sum);
	}

	// +�� ���� ���ڵ��� �� ���ϴ� �Լ�
	private static int add(String str) {
		String[] srr = str.split("\\+");
		int sum = 0;
		for(int i=0; i<srr.length; i++) {
			sum += Integer.parseInt(srr[i]);
		}
		
		return sum;
	}

}
