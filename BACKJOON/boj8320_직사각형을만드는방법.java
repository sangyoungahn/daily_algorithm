package boj8320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj8320_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		
//		i	j	sum		n=(6)
//		1	1	1
//		1	2	X(범위초과)
//		2	1	2
//		2	2	X(범위초과)
//		3	1	3
//		3	2	X(범위초과)
//		4	1	4
//		4	2	5
//		4	3	X(범위초과)
//		5	1	6
//		5	2	X
//		5	3	X(범위초과)
//		6	1	7
//		6	2	8
//		6	3	X(범위초과)
		for(int i=1;i<=n;i++) {	//n:사각형의 개수
			for(int j=1;j*j<=i;j++) {	//j:줄
				if(i%j==0)	cnt++;	//줄마다의 사각형의 개수가 짝수냐?
			}
		}
		
		System.out.println(cnt);
	}

}
