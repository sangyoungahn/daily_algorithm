package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1920_수찾기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int searchNum = 0;
		int index;	//binarySearch 사용 시 반환값
		
		String[] srr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(srr[i]);
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		srr = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			searchNum = Integer.parseInt(srr[i]);
			// 이진탐색 함수 사용
			/*
			 * binarySearch() 메소드
			 * 정렬이 되어있는 배열을 가지고 있다고 가정할 때,
			 * 1. 그 배열에서 매개변수로 넣은 값이 이미 존재하는지 여부와
			 * 그와 동시에 만약 있다면 이 배열의 index번호상으로 몇번에 위치하는지,
			 * 2. 존재하지 않는다면 이 배열의 정렬된 현재 상태와 비교하여 매개변수로 넣은 값이 배열에 추가되었다고 가정할 때
			 * 이 배열에서 몇번째 순서로 위치할지 알 수 있도록 하는 기능을 가지고 있다.
			 */
			index = Arrays.binarySearch(arr, searchNum);
			
			if(index < 0)
				System.out.println(0);
			else
				System.out.println(1);
		}
	}

}
