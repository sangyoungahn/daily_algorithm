package com.ssafy.algo;

import java.util.Scanner;

public class Solution21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
//		int[] result = new int[T];	//result 값을 저장하는 배열

		//테스트 케이스만큼 반복
		for(int t=0; t<T; t++) {		//테스트케이스
			int N = sc.nextInt();		//연못의 한 변의 길이
			int num = sc.nextInt();		//소금쟁이의 수
			int[][] pond = new int[N][N];		//연못의 크기
			boolean check = false;	//마지막까지 흔적에 걸리지 않으면 0을 출력하기 위한 변수
			System.out.print("#" + (t+1) + " ");

			//소금쟁이 수만큼 반복
			for(int k=0; k<num; k++) {
				int x = sc.nextInt();	//x좌표
				int y = sc.nextInt();	//y좌표
				int dir = sc.nextInt();	//방향
				
				//입력 받은 x,y를 초기 위치에 넣음
//				pond[x][y] = 1;
				
				//초기값에 1이 있으면
				if(pond[x][y] == 1) {
					System.out.println(num);	//소금쟁이 번호 출력
				}
				
				//초기값이 1이 아니면
				else {
					pond[x][y] = 1;		//초기 위치에 1을 넣음
					//dir=1이면 연못 배열에서 아래로 이동(배열의 y값을 증가시켜줌)
					if(dir==1) {
						for(int j=3; j>0; j--) {
							x += j;					//y값에 +3,+2,+1을 각각 해줌
							if(y >= N)		//연못의 범위를 넘으면 점프 멈춤
								break;
							else {						//연못의 범위를 넘지 않고 
								if(pond[x][y] == 1) {	//연못의 뛴 자리에 흔적이 있으면
									System.out.println(num);	//소금쟁이 번호 출력
									pond[x][y] = 2;
									check = true;	//겹치는 소금쟁이가 있으면 true로 저장
								}
							}
							if(pond[x][y] == 0)	{	//1인데도 계속 출력할 수 있으므로
								pond[x][y] = 1;		//연못의 범위를 넘지않고, 흔적도 없으면 그 자리에 1을 저장
							}
						}
//						result[t] = 0;		//pond[x][y] 값이 1이 아니라는 것은 소금쟁이가 지나갈 때 흔적이 있는 자리가 없었다는 것
					}

					//dir=2이면 연못 배열에서 오른쪽으로 이동(배열의 x값을 증가시켜줌)
					else {
						for(int j=3; j>0; j--) {
							y += j;		//x값에 +3,+2,+1을 각각 해줌
							if(x >= N)		//연못의 범위를 넘으면 점프 멈춤
								break;
							else {					//연못의 범위를 넘지 않고 
								if(pond[x][y] == 1) {	//연못의 뛴 자리에 흔적이 있으면
									System.out.println(num);	//소금쟁이 번호 출력
									pond[x][y] = 2;
									check = true;	//겹치는 소금쟁이가 있으면 true로 저장
								}
							}
							if(pond[x][y] == 0)	{
								pond[x][y] = 1;		//연못의 범위를 넘지않고, 흔적도 없으면 그 자리에 1을 저장
							}
						}
//						result[t] = 0;		//pond[x][y] 값이 1이 아니라는 것은 소금쟁이가 지나갈 때 흔적이 있는 자리가 없었다는 것
					}
				}
			}
			
			if(check == false) {
				System.out.println(0);
			}
		}
		
//		for(int t=0; t<T; t++) {
//			System.out.print("#" + t+1);
//			System.out.println(" " + result[t]);
//		}
	}
}