import java.util.ArrayList;

/*
 * for문으로도 가능함. 하지만 복잡하므로 재귀가 편함
 * 부분집합의 개수가 2,4,8,16...이런식으로 늘어남
 */
public class PowerSetRecursive {
	

	public static void main(String[] args) {
		int[] arr = {1,10,3,-3,-10};
//		부분 집합의 합의 결과가 0인 경우의 부분 집합의 갯수를 출력하라
//		{}, {1}, {-10}, {1,-3}, {1,10,3,-3,-10};
		boolean[] checked = new boolean[arr.length];
		method2(arr,0,arr.length,checked);
	}
	
	static void method2(int[] arr, int num, int max, boolean[] checked) {
//		종료, 실행 명령문, 자기호출
//		종료 조건은 가장 윗부분에 두기!!
		if(num == max) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<checked.length;i++) {
				if(checked[i]) {	//true인 것만 배열에 넣음
					list.add(arr[i]);
				}
			}
			
			int sum=0;
			for(int su : list) {
				sum += su;
			}
			if(sum == 0 && list.size() != 0) {	//배열에 넣었던 것을 출력
				System.out.println(list);
			}
			return;
		}
		
		//num번째가 선택되었을때
		checked[num] = true;
		method2(arr, num+1, max, checked);
		
		//num번째가 선택 안되었을때
		checked[num] = false;
		method2(arr, num+1, max, checked);
	}
}