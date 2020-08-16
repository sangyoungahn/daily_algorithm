package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bij1181_�ܾ����� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		String temp = null;
		
		//ArrayList�� ������ ����
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		//�迭 ���� ���ϸ鼭 ���ڿ� ���̰� ª�� ������ ����
		for(int i=1; i<N; i++) {
			for(int j=i; j>0; j--) {
				//���� ���ڿ��� ���̰� �� ª���� �ڸ� ����
				if( arr[j].length() < arr[j-1].length() ) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				
			}
		}
		
		//���ڿ� ���̰� ���� ��� ������ �������� ����
		for(int i=0; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				//���̰� ���� ���
				if(arr[i].length() == arr[j].length()) {
					//���� ���ڰ� ���������� ������ �� ���� �ٲ�
					if(0 > arr[i].compareTo(arr[j])) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
					
				}
			}
		}
		
		//�迭�� ArrayListó�� ����
		//�ڡڡڡڡ� asList�� �� ��, new ArrayList�� ������� remove�� ����� �� ����!
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		
		//���� ���ڿ��� ���� ��� 
		for(int i=0; i<list.size()-1; i++) {
			//���� �� 2���� ������ ó���� �����
			if(list.get(i).equals(list.get(i+1))) {
//				System.out.println(list.get(i) + "�� ������!!!!");
				list.remove(i);
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		//�迭 ���
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
