package ngv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ngv_가장큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);
		int K = Integer.parseInt(srr[1]);
		
		String s = br.readLine();
		ArrayList<Long> list = new ArrayList<>();
		long numLong = 0;
		int end = K;
		for(int start=0; start<=N-3; start++) {
			if(start != (N-K)) {
				System.out.println("start : " + start + ", " + "end : " + end);
				numLong = Long.parseLong(s.substring(start, end));
				System.out.println("(if)numInt : " + numLong);
				list.add(numLong);
				end++;				
			} else if(start == (N-K)) {
				System.out.println("start : " + start + ", " + "end : " + end);
				numLong = Long.parseLong(s.substring(start));
				System.out.println("(else if)numInt : " + numLong);
				list.add(numLong);
				break;
			}
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		
		System.out.println(list.get(0));
	}

}
