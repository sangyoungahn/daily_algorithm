package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		
		String[] srr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(srr[i]));
		}
		
		Collections.sort(list);
		
		//~~까지 반복할 숫자 뽑기
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				sum += list.get(j);
			}
		}
		
		System.out.println(sum);
	}

}
