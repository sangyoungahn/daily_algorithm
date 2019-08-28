import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class robot_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());

			char[][] map = new char[N][N];
			for(int i=0;i<N;i++) {
				String[] srr = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=srr[j].charAt(0);
				}
			}//full

//			//출력테스트
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}

			//배열 탐색
			int result=0;
			int cntA=0, cntB=0, cntC=0;

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {

					if(map[i][j] == 'A') {
						//1.오른쪽 탐색
						for(int k=1;k<N;k++) {
							//배열 넘으면 종료
							if(j+k>=N) break;

							if(map[i][j+k]=='B')	break;
							else if(map[i][j+k]=='C')	break;
							else if(map[i][j+k]=='W')	break;
							//S면 계속 탐색해야되므로 continue
							else if(map[i][j+k]=='S') {
								cntA++;
								continue;
							}
						}
					}

					else if(map[i][j] == 'B') {
						//1.왼쪽 탐색
						for(int k=1;k<N;k++) {
							//배열 넘으면 종료
							if(j-k<0) break;

							if(map[i][j-k]=='A') break;
							else if(map[i][j-k]=='C') break;
							else if(map[i][j-k]=='W') break;
							//S면 계속 탐색해야되므로 continue
							else if(map[i][j-k]=='S') {
								cntB++;
								continue;
							}
						}
						
						//2.오른쪽 탐색
						for(int k=1;k<N;k++) {
							//배열 넘으면 종료
							if(j+k>=N) break;

							if(map[i][j+k]=='A') break;
							else if(map[i][j+k]=='C') break;
							else if(map[i][j+k]=='W') break;
							//S면 계속 탐색해야되므로 continue
							else if(map[i][j+k]=='S') {
								cntB++;
								continue;
							}
						}
					}

					else if(map[i][j] == 'C') {
						//1.위 탐색
						for(int k=1;k<N;k++) {
							//배열 넘으면 종료
							if(i-k<0) break;
							
							if(map[i-k][j]=='A') break;
							else if(map[i-k][j]=='B') break;
							else if(map[i-k][j]=='W') break;
							//S면 계속 탐색해야되므로 continue
							else if(map[i-k][j]=='S') {
								cntC++;
								continue;
							}
						}
						
						//2.아래 탐색
						for(int k=1;k<N;k++) {
							//배열 넘으면 종료
							if(i+k>=N) break;
							
							if(map[i+k][j]=='A') break;
							else if(map[i+k][j]=='B') break;
							else if(map[i+k][j]=='W') break;
							//S면 계속 탐색해야되므로 continue
							else if(map[i+k][j]=='S') {
								cntC++;
								continue;
							}
						}
						
						//3.왼쪽 탐색
						for(int k=1;k<N;k++) {
							//배열 넘으면 종료
							if(j-k<0) break;
							
							if(map[i][j-k]=='A') break;
							else if(map[i][j-k]=='B') break;
							else if(map[i][j-k]=='W') break;
							//S면 계속 탐색해야되므로 continue
							else if(map[i][j-k]=='S') {
								cntC++;
								continue;
							}
						}
						
						//4.오른쪽 탐색
						for(int k=1;k<N;k++) {
							//배열 넘으면 종료
							if(j+k>=N) break;
							
							if(map[i][j+k]=='A') break;
							else if(map[i][j+k]=='B') break;
							else if(map[i][j+k]=='W') break;
							//S면 계속 탐색해야되므로 continue
							else if(map[i][j+k]=='S') {
								cntC++;
								continue;
							}
						}
					}
				}
			}//전체for
			
			result=cntA+cntB+cntC;
			System.out.println("#"+tc+" "+result);
		}//tc
	}
}
