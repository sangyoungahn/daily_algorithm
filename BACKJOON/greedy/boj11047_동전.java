package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj11047_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);
		int K = Integer.parseInt(srr[1]);
		ArrayList<Integer> moneyList = new ArrayList<Integer>();
		int result=0;
		int money=0;
		
		//input
		for(int i=0; i<N; i++) {
			moneyList.add(Integer.parseInt(br.readLine()));
		}
		//ArrayList 뒤집기
		Collections.reverse(moneyList);
		
		for(int i=0; i<N; i++) {
			money = moneyList.get(i);
			if(K>=money) {
				result += (K/money);
				K %= money;
				
				if(K==0)	break;
			}
		}
		
		System.out.println(result);
	}

}
