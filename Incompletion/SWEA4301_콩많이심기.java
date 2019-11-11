import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA4301_콩많이심기 {
	static ArrayList<Loc> list;
	static boolean[][] visited;
	static int cnt=1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] srr = br.readLine().split(" ");
			int N = Integer.parseInt(srr[0]);	//기로 길이=3
			int M = Integer.parseInt(srr[1]);	//세로 길이=2
			
			list = new ArrayList<>();
			visited = new boolean[M][N];
			//원소 주입
			for(int i=0; i<M; i++) {	//2
				for(int j=0; j<N; j++) {	//3
					Loc loc = new Loc(i, j);
					list.add(loc);
				}
			}
			
			//거리 계산
			for(int k=0; k<list.size(); k++) {
				//비교 기준 원소
				Loc from = list.get(k);
				//각각의 원소를 list에서 뽑아 배열 각 원소와 거리 비교
				for(int i=0; i<M; i++) {	//행=2
					for(int j=0; j<N; j++) {	//열=3
						//비교할 대상 잡기
						Loc to = new Loc(i, j);
						//거리 계산
						double dis = (double)Math.sqrt( (to.x-from.x)*(to.x-from.x) + (to.y-from.y)*(to.y-from.y));
						
						//거리가 2이고 이미 방문한 곳이 아니라고 하면, 다시 비교대상 잡아서 탐색
						if(dis==2 && !visited[i][j])	continue;
						//거리가 2이고 이미 방문한 곳이라고 하면, 카운트를 하나 감소시키고 다시 비교대상 잡아서 탐색
						else if(dis==2 && visited[i][j]) {
							cnt--;
							continue;
						}
						//거리가 0과 2가 아니고 아직 방문하지 않은 곳이라면, 카운트 증가시키고 방문 했다고 변경
						else if(dis!=0 && dis!=2 && !visited[i][j]) {
							cnt++;
							visited[i][j]=true;
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}//tc
	}
	
	static class Loc {
		int x;
		int y;
		
		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
