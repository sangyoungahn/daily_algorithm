package level3;

public class ��Ʈ��ũ {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		boolean[] visited = new boolean[n]; // �ش� ��� �湮üũ
		int cnt = 0;

		// ��ü ��ǻ�� �湮
		for (int index = 0; index < n; index++) {
			// ���� ��ġ�� �̹� �湮�� ������ ���� ����
			if (!visited[index]) {
				// ù Ž�� ������ ����Լ� ����
				dfs(index, computers, visited);
				// �� ����Ŭ�� ���� ����� ��Ʈ��ũ�� ����Ƿ�, dfs�� ��� ������ ���� 1�� ����������
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
	
	public static void dfs(int index, int[][] computers, boolean[] visited){
        //�湮�ߴٰ� ǥ��
        visited[index] = true;
        
        //����� ��� �� ���ǿ� �´� �� Ž��
        for(int i=0; i<computers.length; i++){
            //"1. �ڽ��� ������ �� �߿��� 2. ����� ����̰� 3. ���� �湮�� ���� ���� ���" �̸� Ž��
            if(index != i && computers[i][index] == 1 && !visited[i]){
                dfs(i, computers, visited);
            }
        }
    }
}
