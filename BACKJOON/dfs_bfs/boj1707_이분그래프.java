package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj1707_�̺б׷��� {
	static int[] team;
	static ArrayList<ArrayList<Integer>> graph;
	static int V,E;
	static String ans;
	static int A,B;
	static int RED = 1, GREEN = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// �׽�Ʈ���̽� 3�� �ݺ�
		for(int t=0; t<T; t++) {
			ans = "YES";
			String[] srr = br.readLine().split(" ");
			V = Integer.parseInt(srr[0]);
			E = Integer.parseInt(srr[1]);
			
			// �������� 1���� ArrayList�� ���� -> �������� ����Ǵ� �������� ������ �˾ƾ��ϹǷ�
			graph = new ArrayList<>();
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<E; i++) {
				srr = br.readLine().split(" ");
				A = Integer.parseInt(srr[0])-1;
				B = Integer.parseInt(srr[1])-1;
				
				// ������ ���� ���������
				graph.get(A).add(B);
				graph.get(B).add(A);
			}
			
			//������ ����ŭ ��ȣ ����
			team = new int[V];
			//������ Ž���ϸ� ��ĥ����(�׷������� ����)
			for(int i=0; i<V; i++) {
				if(team[i]==0) {
					if(!bfs(i))	break;
				}
			}
			
			System.out.println(ans);
		}
	}

	private static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		team[n] = RED;
		while(!q.isEmpty()) {
			int node = q.poll();
			
			// node�� ����� �͵� ��ΰ� i�� ����
			for(Integer i : graph.get(node)) {
				// ������ ���� ���� ���� ������ üũ
				if(team[node] == team[i]) {
					ans = "NO";	// �̺� �׷����� �ƴ϶�� ��
					return false;
				}
				//���� �湮���� �ʾ����� �ڽŰ� �ݴ�Ǵ� ���� �ִ´�.
				if(team[i]==0) {
					team[i] = team[node] * -1;
					q.add(i);
				}
			}
		}
		
		return true;
	}

}
