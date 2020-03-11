package FullSearch;

public class Carpet {

	public static void main(String[] args) {
		int brown = 24;
		int red = 24;
		int[] answer = new int[2];
		
		int sum = brown + red;	//48
		int sqrt = (int) Math.sqrt(sum);	//6
		int mul = sqrt * sqrt;	//36
		
		if(mul == sum) {
			answer[0] = sqrt;
			answer[1] = sqrt;
		}else{
			int i=1;
			answer[0] = sqrt;
			answer[1] = sqrt;
			while(true) {
				System.out.println("반복 시작"+"("+i+")번째");
				i++;
				System.out.println("mul : " + mul);
				System.out.println("sum : " + sum);
				System.out.println("sqrt : " + sqrt);
				answer[0]++;
				System.out.println("answer[0] : "+answer[0]);
				System.out.println("answer[1] : "+answer[1]);
				System.out.println("========================");
				
				if(answer[0] * answer[1] == sum) {
					System.out.println("break문 걸림");
					break;
				}
			}
		}
		
		System.out.print(answer[0]+", ");
		System.out.println(answer[1]);
	}

}
