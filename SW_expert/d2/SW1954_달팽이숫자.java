package swea.d2;

import java.util.Scanner;

public class SW1954_달팽이숫자 {
	//오른쪽, 아래, 왼쪽, 위를 설정하는 변수
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	static final int UP = 4;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int num = sc.nextInt();
			int[][] map = new int[num][num];
			int dir = 1;
			int x=0, y=0;
			
			//경계를 설정하기 위한 변수
			int maxLeft=0, maxRight=num-1;
			int maxUp=1, maxDown=num-1;
			
			for(int n=1; n<=num*num; n++) {
				map[y][x]=n;	//아래의 조건문에 해당하는 곳에서 값을 하나 증가시켜 배열에 값을 넣어줌
				
				if(dir==RIGHT) {
					if(x==maxRight) {	//x가 오른쪽의 가장 끝이면
						maxRight--;	//다음에는 하나 적게 가야하므로 전체에서 하나를 줄여줌
						dir=DOWN;	//다음에 갈 방향
						y++;
					}
					else x++;	//x가 오른쪽의 가장 끝이 아니면 하나씩 이동
				} else if(dir==DOWN) {
					if(y==maxDown) {
						maxDown--;
						dir=LEFT;
						x--;
					}
					else y++;
				} else if(dir==LEFT) {
					if(x==maxLeft) {
						maxLeft++;
						dir=UP;
						y--;
					}
					else x--;
				} else if(dir==UP) {
					if(y==maxUp) {
						maxUp++;
						dir=RIGHT;
						x++;
					}
					else y--;
				}
			}
			
			
			System.out.println("#" + (t+1));
			for(int i=0; i<num; i++) {	//행
				for(int j=0; j<num; j++) {	//열
					 System.out.print(map[i][j]);
						 System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
}
