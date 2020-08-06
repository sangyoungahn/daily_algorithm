import java.util.Scanner;

public class 원하는문자가입력될때까지반복출력하기 {

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
