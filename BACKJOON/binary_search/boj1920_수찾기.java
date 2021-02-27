package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1920_��ã�� {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int searchNum = 0;
		int index;	//binarySearch ��� �� ��ȯ��
		
		String[] srr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(srr[i]);
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		srr = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			searchNum = Integer.parseInt(srr[i]);
			// ����Ž�� �Լ� ���
			/*
			 * binarySearch() �޼ҵ�
			 * ������ �Ǿ��ִ� �迭�� ������ �ִٰ� ������ ��,
			 * 1. �� �迭���� �Ű������� ���� ���� �̹� �����ϴ��� ���ο�
			 * �׿� ���ÿ� ���� �ִٸ� �� �迭�� index��ȣ������ ����� ��ġ�ϴ���,
			 * 2. �������� �ʴ´ٸ� �� �迭�� ���ĵ� ���� ���¿� ���Ͽ� �Ű������� ���� ���� �迭�� �߰��Ǿ��ٰ� ������ ��
			 * �� �迭���� ���° ������ ��ġ���� �� �� �ֵ��� �ϴ� ����� ������ �ִ�.
			 */
			index = Arrays.binarySearch(arr, searchNum);
			
			if(index < 0)
				System.out.println(0);
			else
				System.out.println(1);
		}
	}

}
