package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programmers_기능개발 {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		int[] answer = {};
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> cntList = new ArrayList<Integer>();
        
        for(int i=0; i<progresses.length; i++){
            q.add( (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1); 
        }
        
        int standard = q.poll();
        int cnt = 1;    // 큐에서 하나 꺼내오면 그 자체로 1이 됨
        while(!q.isEmpty()){
            int num = q.poll();
            if(standard >= num) {
                cnt++;
            } else {
                cntList.add(cnt);
                cnt = 1;    // cnt 초기화
                standard = num;
            }
        }
        // 9, 5에서 끝났을 경우 else로 들어가지 않으므로 밖에서 cnt를 저장해줘야함
        cntList.add(cnt);
        answer = new int[cntList.size()];
        for(int i=0; i<cntList.size(); i++){
            answer[i] = cntList.get(i);
        }
        
        // answer 출력
        System.out.println(Arrays.toString(answer));
	}

}
