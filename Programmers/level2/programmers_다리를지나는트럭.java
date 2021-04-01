package level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1. 풀이시간 : 
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 	(case 1) 큐가 비어있는 경우
 * 		트럭이 무조건 지나갈 수 있기 때문에 큐에 add()
 * 		다리 위 트럭들의 무게를 의미하는 sum 변수에 진입한 트럭의 무게를 더해줌
 * 		걸린 시간도 1 더해줌
 * 	(case 2) 큐의 사이즈 == 다리의 길이
 * 		큐가 가득찼으므로 가장 먼저 진입한 트럭이 다리의 끝자락에 위치해있다는 뜻 -> 트럭을 다리 밖으로 지나가게 하기 위해 poll() 해줌
 * 		다리 위 트럭들의 무게를 의미하는 sum에서 다리를 빠져나간 트럭의 무게 빼줌
 * 	(case 3) 트럭이 다리 위에 있지만, 큐가 가득 차지 않은 상태
 * 		이미 다리 위의 있는 트럭들의 무게와 새롭게 진입할 트럭의 무게의 합이 weights(다리가 버틸 수 있는 무게)를 초과하는지 아닌지 검사
 * 		weights보다 크다면, 새로운 트럭은 진입할 수 없음 -> 큐에는 0을 넣어서 이미 큐에 있는 트럭이 혼자 다리를 지나가도록 해줌
 * 											  (큐에 0을 넣는 이유 : 큐의 사이즈를 늘려서 case2의 조건에 부합하게 해야함)
 * 		weights보다 작다면, 새로운 트럭이 진입할 수 있음 -> 첫 번째 조건과 마찬가지로 큐에 새로 진입할 트럭을 넣어주고 sum에 새롭게 진입한 트럭의 무게를 더해줌
 * 
 * 	마지막으로 들어온 트럭도 다리를 모두 지나가야하기 때문에 현재 걸린 시간에 다리의 길이만큼 더해줌
 */	
public class programmers_다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		int sum = 0;
		int time = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int truck : truck_weights) {
			while(true) {
				if(q.isEmpty()) {
					q.add(truck);
					sum += truck;
					time++;
					break;
				} else if(q.size() == bridge_length) {
					sum -= q.poll();
				} else {
					if(sum + truck > weight) {
						time++;
						q.add(0);	// 새로운 트럭을 받을 필요가 없고, 현재 큐에 들어가 있는 하나의 트럭을 밀어내야하기 때문에 계속 반복문 유지
					} else {
						q.add(truck);
						sum += truck;
						time++;
						break;	// 새로운 트럭을 받아와야하므로 반복문 벗어나게 만들어줌
					}
				}
			}
		}
		
		time += bridge_length;
		System.out.println(time);
	}

}
