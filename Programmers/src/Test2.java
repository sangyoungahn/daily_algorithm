import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = { 2, 1, 3, 1, 4, 2, 1, 3 };
//		int[] arr = { 1, 2, 3};
		int result = 0;
		List<Integer> list = new LinkedList<>();

		// 첫번째 기준 숫자 반복
		outer:for (int i = 0; i < arr.length; i++) {
			// 두번째 비교 숫자 반복(끝까지 비교해야하므로 arr배열의 길이만큼 반복)
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					list.add(j - i);
//					System.out.println("add list : " + list.get(i));
					break;
				}
//				else {
//					result = -1;
//					System.out.println(result);
//					break outer;
//				}
			}
		}
		
		
		//이중 for문을 다 돌았는데도 list에 들어간 값이 없으면 -1을 저장
		if(list.size()==0)	result = -1;
		else {
			Collections.sort(list);
			result = list.get(0);
		}
//		System.out.println(result);
		
		

//		// list output test
//		for (i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		System.out.println(result);
	}
}
