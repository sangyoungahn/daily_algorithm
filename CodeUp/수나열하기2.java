import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �������ϱ�2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int a = Integer.parseInt(srr[0]);	//���� ��
		int r = Integer.parseInt(srr[1]);	//����� ��
		int n = Integer.parseInt(srr[2]);	//�� ��° ������
		long mul = a;
		
		for(int i=0; i<n-1; i++) {
//			System.out.println(i+1 + "��° : " + mul + " x " + r);
			mul *= r;
//			System.out.println(i+1 + "��° : " + mul);
		}
		System.out.println(mul);
	}

}
