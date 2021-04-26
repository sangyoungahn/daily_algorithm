package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실전3_2_Incompletion {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		
		int N = Integer.parseInt(srr[0]);
		int M = Integer.parseInt(srr[1]);
		int K = Integer.parseInt(srr[2]);
		
		int[] nums = new int[N];
		List<Integer> list = new ArrayList<Integer>();
		srr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(srr[i]);
			list.add(nums[i]);
		}
		
		// 내림차순 정렬
		Collections.sort(list);
		Collections.reverse(list);
		
		int cnt = 0;
		int sum = 0;
		for(int i=0; i<M; i++) {
			if(cnt==K) {
				sum += list.get(1);
				cnt = 0;
			}
			sum += list.get(0);
			cnt++;
		}
		
		System.out.println(sum);
	}

}
