package day02.sw2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW2001_파리퇴치_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			String s1[] = br.readLine().split(" ");		//한줄 입력받기
			int[] input = new int[s1.length];	//입력값 2개 받을 배열
			for(int i=0;i<s1.length;i++) {
				input[i] = Integer.parseInt(s1[i]);
			}
			
			int size = input[0];	//배열의 크기
			int pSize = input[1];	//파리채 사이즈(2,3,4,...,M)
			int[][] map = new int[size][size];
			int max=0;
			int sum=0;
			
			//map에 값 입력
			for(int i=0;i<size;i++) {
				String s2[] = br.readLine().split(" ");	//문자열을 한줄씩 받아서 s[]배열에 저장
				for(int j=0;j<size;j++) {
					map[i][j]=Integer.parseInt(s2[j]);	//String 배열에 있는 거를 하나하나 잘라서 넣음
				}
			}
			
//			//출력테스트
//			for(int i=0;i<size;i++) {
//				for(int j=0;j<size;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			for(int i=0;i<size;i++) {	//배열을 탐색하면서
				for(int j=0;j<size;j++) {
					
					for(int pi=i; pi<pSize+i; pi++) {
						for(int pj=j; pj<pSize+j; pj++) {
							//파리채의 끝 값이 배열의 크기 안에 들어있어야 더함
							if(pSize+i<=size && pSize+j<=size) {	//pSize, psize 모두 배열의 인덱스 값이 아니므로 =까지 들어감
								sum += map[pi][pj];
							}
							
						}
					}
					if(max < sum) {	//4개를 더한 값이 더 크면 max에 새로운 값을 넣어줌
						max = sum;
					}
					sum=0;
				}
			}//for
			
			System.out.println("#"+t+" "+max);
		}
	}

}
