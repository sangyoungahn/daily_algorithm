package medium;
/*
 * 1. Ǯ�̽ð� : 40��
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * 	(1) ���� ��ġ�� ��(1)�� ���������� dfs Ž�� ����
 * 	(2) dfs Ž���� �ϸ鼭 ��(0)�̰ų�, �̹� Ž���� ���̸� Ž������ �ʰ� ������ ���ȣ���� �κ����� ���ư�
 * 	(3) main���� findIsland �Լ��� ������ �Ǹ� ���� �ϳ� ã�� ���̹Ƿ� ī��Ʈ 1���� 
 */
public class leetcode_Number_of_Islands {
	static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static boolean[][] visited;

	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		int answer = 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    findIsland(i,j,grid);
                    answer++; //�� ����� ���� ã���� ���� ����, �� ���� ���ư��� �ٸ� ��ġ�� Ž�� ���� �κ� ã��
                }
            }
        }
        
        System.out.println(answer);
	}
	
    public static void findIsland(int si, int sj, char[][] grid){
        // ������ġ�� ���̰ų�, �̹� Ž���� ���̶�� ����
        if(grid[si][sj]=='0' || visited[si][sj])    return;
        
        visited[si][sj] = true;
        
        // 4���� Ž��
        for(int dir=0; dir<4; dir++){
            int ni = si + di[dir];
            int nj = sj + dj[dir];
            
            // ������ ����� �ٸ� ���� Ž��
            if(ni<0 || ni>=grid.length || nj<0 || nj>=grid[0].length) continue;
            
            // ���� ��ġ�� ���̰�, �湮���� ���� ���̶�� ���ȣ��
            if(grid[ni][nj]=='1' && !visited[ni][nj]){
                findIsland(ni,nj,grid);
            }
        }
    }
}
