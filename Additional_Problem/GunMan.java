package day06.gunman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GunMan {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[] srr = br.readLine().split(" ");
			int row = Integer.parseInt(srr[0]);
			int col = Integer.parseInt(srr[1]);
			
			//T를 찾으면 true로 바꾸는 배열(T의 개수에 상관없이)
			boolean[][] isHit = new boolean[row][col];

			//map 그리기
			char[][] map = new char[row][col];
			for(int i=0;i<row;i++) {
				String[] srrMap = br.readLine().split(" ");
				for(int j=0;j<col;j++) {
					map[i][j] = srrMap[j].charAt(0);
				}
			}//full

			//map출력 테스트
//			for(int i=0;i<row;i++) {
//				for(int j=0;j<col;j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}

			int cnt=0;	//T를 찾은 횟수
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					//총잡이 기준으로 탐색
					if(map[i][j]=='G') {
						//위로 탐색
						for(int upSize=1;upSize<row;upSize++) {
							//배열 범위를 넘으면 종료
							if(i-upSize<0)	break;

							if(map[i-upSize][j]=='W')	break;
							else if(map[i-upSize][j]=='T') {
								isHit[i-upSize][j] = true;
								cnt++;
								break;
							}
							else if(map[i-upSize][j]=='G') break;
							else	continue;	//0을 만났을 경우
						}

						//아래로 탐색
						for(int downSize=1;downSize<row;downSize++) {
							//배열  범위를 넘으면 종료
							if(i+downSize>=row)	break;

							if(map[i+downSize][j]=='W')	break;
							else if(map[i+downSize][j]=='T') {
								isHit[i+downSize][j] = true;
								cnt++;
								break;
							}else if(map[i+downSize][j]=='G') break;
							else	continue;
						}

						//왼쪽으로 탐색
						for(int leftSize=1;leftSize<col;leftSize++) {
							//배열  범위를 넘으면 종료
							if(j-leftSize<0)	break;

							if(map[i][j-leftSize]=='W')	break;
							else if(map[i][j-leftSize]=='T') {
								isHit[i][j-leftSize] = true;
								cnt++;
								break;
							}else if(map[i][j-leftSize]=='G') break;
							else	continue;
						}

						//오른쪽으로 탐색
						for(int rightSize=1;rightSize<col;rightSize++) {
							//배열  범위를 넘으면 종료
							if(j+rightSize>=col)	break;

							if(map[i][j+rightSize]=='W')	break;
							else if(map[i][j+rightSize]=='T') {
								isHit[i][j+rightSize] = true;
								cnt++;
								break;
							}else	continue;
						}
					}
				}
			}
			
			//boolean배열에서 true인 것만 찾아서 카운트(cnt가 얼마인지 상관없이)
			int sumCnt=0;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(isHit[i][j]) sumCnt++;
				}
			}
			System.out.println("#"+tc+" "+sumCnt);
			System.out.println("T를 찾은 횟수가 중복되었을때 : "+cnt);
		}//tc
	}

}
