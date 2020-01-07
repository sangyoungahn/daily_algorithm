package boj10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10871_X보다작은수 {
	static int[] map;
	static int N, X;
	static int idx=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		
		N = Integer.parseInt(srr[0]);
		X = Integer.parseInt(srr[1]);
		
		map = new int[N];
		srr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(srr[i]);
		}
		
		recur(idx);
	}

	private static void recur(int idx) {
		//종료조건
		if(idx>N-1)	return;
		
		if(map[idx]<X)	System.out.print(map[idx]+" ");
		recur(idx+1);
	}

}
