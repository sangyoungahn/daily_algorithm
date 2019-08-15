import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HomeProblem3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			int n = Integer.parseInt(br.readLine());
			
			char[][] map = new char[n][n];	//2차원 배열
			int result=0;	//결과값
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				for(int j=0;j<n;j++) {
					 map[i][j] = str.charAt(j);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//위치가 집도 아니고, X도 아니라면 = 기지국이라면
					if(map[i][j]!='H' && map[i][j]!='X') {
						//탐색 크기를 결정
						int size=0;
						if(map[i][j] == 'A') {
							size=1;
						}else if(map[i][j] == 'B') {
							size=2;
						}else if(map[i][j] == 'C') {
							size=3;
						}

						//A,B,C 중 하나가 걸리면 그 크기로 상,하,좌,우를 탐색해야하므로 이 위치에 있어야함!
						//상,하,좌,우를 탐색 크기만큼 탐색하여 H를 X로 변경
						for(int k=1;k<=size;k++) {
							//상
							if(i-k > 0 && map[i-k][j] == 'H') {
								map[i-k][j]='X';
							}
							//하
							if(i+k < n && map[i+k][j] == 'H') {
								map[i+k][j]='X';
							}
							//좌
							if(j-k > 0 && map[i][j-k] == 'H') {
								map[i][j-k]='X';
							}
							//우
							if(j+k < n && map[i][j+k] == 'H') {
								map[i][j+k]='X';
							}
						}

					}
					
				}
				
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]=='H') {
						result++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
			
//			//출력 테스트
//			for(int i=0;i<map.length;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
		}
	}

}
