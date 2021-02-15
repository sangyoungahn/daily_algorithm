package priority_queue;
/*
 * 1. Ǯ�̽ð� : 30��
 * 2. Ǯ�̹��
 * 		�ڿ��� -> �迭�� �ش� ���� �߰�
 * 		0 -> �迭���� ���� ���� ���� ���, �� ���� �迭���� ����
 * 		 (�迭�� ��� �ִ� ����ε� ���� ���� ���� ����϶�� �� ��쿡�� 0�� ���)
 * 3. ���� �ð����⵵ : O(NlogN) -> �켱����ť�� �ð����⵵
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_�ּ��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// PriorityQueue�� �⺻������ �������� ����
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0)
				sb.append(pq.size() == 0 ? 0 : pq.poll()).append('\n');		// poll() : priorityQueue�� ù��° ���� ��ȯ�ϰ� ���� ����ִٸ� null
			else
				pq.add(num);
		}
		
		System.out.println(sb.toString());
	}

}
