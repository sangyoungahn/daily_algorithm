package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bij1181_단어정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		String temp = null;
		
		//ArrayList에 데이터 삽입
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		//배열 안을 비교하면서 문자열 길이가 짧은 순서로 정렬
		for(int i=1; i<N; i++) {
			for(int j=i; j>0; j--) {
				//뒤의 문자열의 길이가 더 짧으면 자리 변경
				if( arr[j].length() < arr[j-1].length() ) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				
			}
		}
		
		//문자열 길이가 같을 경우 사전적 오름차순 정렬
		for(int i=0; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				//길이가 같을 경우
				if(arr[i].length() == arr[j].length()) {
					//뒤의 문자가 사전적으로 먼저일 때 순서 바꿈
					if(0 > arr[i].compareTo(arr[j])) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
					
				}
			}
		}
		
		//배열을 ArrayList처럼 쓰기
		//★★★★★ asList를 쓸 때, new ArrayList로 감싸줘야 remove를 사용할 수 있음!
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		
		//같은 문자열이 있을 경우 
		for(int i=0; i<list.size()-1; i++) {
			//같은 것 2개가 있으면 처음걸 지우기
			if(list.get(i).equals(list.get(i+1))) {
//				System.out.println(list.get(i) + "가 삭제됨!!!!");
				list.remove(i);
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		//배열 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
