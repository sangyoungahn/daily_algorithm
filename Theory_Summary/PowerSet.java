import java.util.ArrayList;

/*
 * for문으로도 가능함. 하지만 복잡하므로 재귀가 편함
 * 부분집합의 개수가 2,4,8,16...이런식으로 늘어남
 */
public class PowerSet {
	

	public static void main(String[] args) {
		int[] arr = {1,10,3,-3,-10};
//		부분 집합의 합의 결과가 0인 경우의 부분 집합의 갯수를 출력하라(조건)
//		{}, {1}, {-10}, {1,-3}, {1,10,3,-3,-10};
		method1(arr);
	}
	
	static void method1(int[] arr) {
		int size = (int) Math.pow(2, arr.length);
//		System.out.println(size);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum=0;
		int cnt=0;
		
		for(int i=0;i<size;i++) {	//행
			list.clear();
			for(int j=0;j<arr.length;j++) {	//열
				//자리가 1이면 배열의 값을 그대로 쓰면 됨
				if( (i & 1<<j) != 0) {	//<< : j비트만큼 오른쪽으로 비트를 이동
					list.add(arr[j]);
				}
			}
			sum=0;
			for(int num : list) {
				sum += num;
			}
			
			if(sum == 0 && list.size() != 0) {
				cnt++;
				System.out.println(list + " ,"+ sum);
			}
		}
		System.out.println(cnt);
	}
}
