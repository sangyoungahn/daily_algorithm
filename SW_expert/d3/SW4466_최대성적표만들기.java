package day07.sw4466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SW4466_최대성적표만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[] srr = br.readLine().split(" ");
			int N = Integer.parseInt(srr[0]);
			int K = Integer.parseInt(srr[1]);
			
			ArrayList<Integer> list = new ArrayList<>();
			String[] srrScore = br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(srrScore[i]));
			}
			
			//내림차순
			Collections.sort(list);
			Collections.reverse(list);
			
//			//출력 테스트
//			for(int i=0;i<list.size();i++) {
//				System.out.print(list.get(i)+" ");
//			}
			
			int result=0;
			for(int i=0;i<K;i++) {
				result += list.get(i);
			}
			
			System.out.println("#"+tc+" "+result);
		}//tc
	}

}
