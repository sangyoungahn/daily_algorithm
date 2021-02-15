package priority_queue;
/*
 * 1. 풀이시간 : 30분
 * 2. 풀이방법
 * 		자연수 -> 배열에 해당 값을 추가
 * 		0 -> 배열에서 가장 작은 값을 출력, 그 값을 배열에서 제거
 * 		 (배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력)
 * 3. 예상 시간복잡도 : O(NlogN) -> 우선순위큐의 시간복잡도
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_최소힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// PriorityQueue는 기본적으로 오름차순 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0)
				sb.append(pq.size() == 0 ? 0 : pq.poll()).append('\n');		// poll() : priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
			else
				pq.add(num);
		}
		
		System.out.println(sb.toString());
	}

}
