package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1697_���ٲ��� {
	static int[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		int N = Integer.parseInt(srr[0]);
		int K = Integer.parseInt(srr[1]);
		check = new int[100001];
		
		// �����̿� ������ ��ġ�� ���ٸ� �̵��� �ʿ� X
		if(N==K) {
			System.out.println("0");
			return;
		}
		bfs(N,K);
		
		System.out.println(check[K]);
	}

	private static char[] bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[n] = 0;	//�������� ��ġ�� 0���� �ʱ�ȭ
		q.add(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			// ������ ��ġ���� 0�� �ƴϸ� �̹� �ּڰ��� ã�� ���̹Ƿ� ��� (�迭�� ũ�Ⱑ 100001�̹Ƿ� �ð��� �����̶� �����Ű�� ����)
			if(check[k] != 0)	break;
			
			// -1 �̵�
			if((x-1>=0) && check[x-1]==0) {	// -1�� ��ġ�� 0���� Ŀ����. -1�� ��ġ�� check �迭�� 0�̾�� ���� �ּڰ� ã�� ���ߴٴ� ��
				q.add(x-1);		// �̵��� ��ġ�� ����
				check[x-1] = check[x] + 1;	// -1�� ��ġ������ �ּ��̵�Ƚ��
			}
			// +1 �̵�
			if((x+1<check.length) && check[x+1]==0) {
				q.add(x+1);
				check[x+1] = check[x] + 1;
			}
			// x2 �̵�
			if((x*2<check.length) && check[x*2]==0) {
				q.add(x*2);
				check[x*2] = check[x] + 1;
			}
		}
		
		return null;
	}

}
