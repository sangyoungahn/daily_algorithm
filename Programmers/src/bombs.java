import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class NDS_test1_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = {3,1,2,4};
//		int[] arr = {2,2,2,2};
		
		int result = 0;
		Arrays.sort(arr);
		
		//처리
		int times = 0;	//리스트에서 가장 작은 값을 초로 잡음
		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
			times++;
			
			if(arr[i]<i+1) {
				times--;
				break;
			}
		}

		System.out.println(times);
	}
}
