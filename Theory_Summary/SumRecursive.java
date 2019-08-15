
public class SumRecursive {
	static int sum=0;	//static 함수에서 사용되려면 변수에도 static이 붙어야 됨
	
	public static void main(String[] args) {
		doSum(1);
		System.out.println(sum);
	}
	
	static void doSum(int num) {
		//종료, 실행 명령문, 자기호출
		//종료 조건은 가장 윗부분에 두기!!
		if(num > 10) {
			return;
		}
		sum = sum + num;
		
		doSum(num+1);
	}

}
