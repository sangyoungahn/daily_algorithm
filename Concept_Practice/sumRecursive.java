
public class sumRecursive {
	static int cnt=0;
	static int sum;
	
	public static void main(String[] args) {
		recur(cnt);
		System.out.println("1~10까지의 합 : " + sum);
	}

	private static void recur(int cnt) {
		//탈출조건
		if(cnt >= 10)	return;
		
		cnt++;
		sum += cnt;
//		System.out.println("sum : " + sum);
		recur(cnt);
	}

}
