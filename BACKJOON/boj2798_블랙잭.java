package boj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2798_블랙잭_MySol {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);
		int M = Integer.parseInt(srr[1]);
		
		//카드값 입력 받기
		int[] card = new int[N];
		srr = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			card[i]=Integer.parseInt(srr[i]);
		}
		
		int sum=0;
		int max=0;
		//카드 3장씩 뽑기
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(i!=j && j!=k && i!=k) {
						sum=card[i]+card[j]+card[k];
						if(M>=sum) {
							if(sum>max) {
								max=sum;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}//main
}
