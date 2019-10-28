
public class dfsbfs_네트워크 {
	static int answer=0;
	static boolean[] visited;

	static void dfs(int index, int[][] computers, int n){
		visited[index] = true;

		for(int j=1; j<n; j++){     //computer[index][j] -> computers[0][0]은 항상 1이므로 j를 1부터 시작함
			//index번 컴퓨터가 j번 컴퓨터와 연결되어 있고, 아직 탐색하지 않았으면 다음 연결 노드로 다시 재귀 탐색
			if(computers[index][j]==1 && visited[j]==false){
				dfs(j, computers, n);
			}
		}
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		visited = new boolean[n];
		for(int i=0; i<n; i++){
			if(visited[i] == false){
				dfs(i, computers, n);   //computer[i][]와 연결된 값을 계속 찾아들어감
				answer++;   //찾아들어가다가 연결이 끊기면 1을 증가
			}
		}
		
		System.out.println(answer);
	}
}