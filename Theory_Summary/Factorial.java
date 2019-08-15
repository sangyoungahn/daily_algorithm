
public class Factorial {

	public static void main(String[] args) {
		int result = fac(5);
		System.out.println(result);
	}
	
	static int fac(int num) {
		//종료, 실행 명령문, 자기호출
		//종료 조건은 가장 윗부분에 두기!!
		if(num == 1) {
			return 1;
		}
		//num * num-1 * num-2 * fac(num-3) ...
		return num * fac(num-1);
		
		//또다른 리턴 방식
		//int res = num * fac(num-1);
		//return res;
	}

}
