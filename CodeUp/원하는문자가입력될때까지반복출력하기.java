import java.util.Scanner;

public class ���ϴ¹��ڰ��Էµɶ������ݺ�����ϱ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			char input = sc.next().charAt(0);
			if(input == 'q') {
				System.out.println(input);
				break;
			}
			
			System.out.println(input);
		}
	}

}
