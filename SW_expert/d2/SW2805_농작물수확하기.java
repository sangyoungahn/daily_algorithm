package day05.sw2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(br.readLine());
			
			//배열에 값 입력
			char[][] chTemp = new char[N][N];
			int[][] map = new int[N][N];
			int sumTotal=0;
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					chTemp[i][j]=str.charAt(j);		//배열에 문자로 저장
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=chTemp[i][j]-'0';		//문자를 int로 바꿔서 저장
//					System.out.print(map[i][j]);
				}
//				System.out.println();
			}
			
			//윗 부분의 합 계산
			int colStart=0;		//열의 시작 인덱스
			int colEnd=map.length;	//열의 끝 인덱스
			int sumUp=0;
			for(int i=map.length/2;i>=0;i--) {
				//여기 colStart, colEnd 왔을때랑 차이-> i를 시작할때부터 하나 줄어들고 시작함
				for(int j=colStart;j<colEnd;j++){
					sumUp += map[i][j];
//					System.out.println(i+","+j+" "+map[i][j]);
				}
				colStart++;
				colEnd--;
			}
//			System.out.println(sumUp);
			
			//아랫부분의 합
			colStart=0;		//열의 시작 인덱스
			colEnd=map.length;	//열의 끝 인덱스
			int sumDown=0;
			for(int i=(map.length/2)+1;i<map.length;i++) {
				colStart++;
				colEnd--;
				for(int j=colStart;j<colEnd;j++) {
					sumDown += map[i][j];
//					System.out.println(i+","+j+" "+map[i][j]);
				}
			}
//			System.out.println(sumDown);
			
			sumTotal = sumUp + sumDown;
			System.out.println("#"+tc+" "+sumTotal);
		}//tc
	}

}
