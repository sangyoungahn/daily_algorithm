package day05.sw1285;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1285_아름이의돌던지기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine());
			String strArr[]=br.readLine().split(" ");
			int[] intArr=new int[N];
			for(int i=0;i<N;i++) {
				intArr[i]=Integer.parseInt(strArr[i]);
//				System.out.println(intArr[i]);
			}
			
			int min=999999;	//0과 가장 차이가 적게 나는 값
			int[] value = new int[N];
			int cnt=0;	//사람수 카운트
			//절대값을 구해서 배열에 넣음
			for(int i=0;i<N;i++) {
				value[i]=Math.abs(intArr[i]);
			}
			
			//가장 적게 차이나는 값 구하기
			for(int i=0;i<N;i++) {
				if(min>value[i])	min=value[i];
			}
			
			//가장 적게 차이가 나도록 던진 사람수 구하기
			for(int i=0;i<N;i++) {
				if(value[i]==min)	cnt++;
			}
			
			System.out.println("#"+tc+" "+min+" "+cnt);
		}//tc
		
	}

}
