package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ½ÇÀü3_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);
		int K = Integer.parseInt(srr[1]);
		
		int cnt = 0;
		while(true) {
			if(N==1)	break;
			
			if(N%K == 0) {
				N /= K;
				cnt++;
			}
			else {
				N--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
