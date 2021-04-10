package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programmers_��ɰ��� {

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
        int cnt = 1;    // ť���� �ϳ� �������� �� ��ü�� 1�� ��
        while(!q.isEmpty()){
            int num = q.poll();
            if(standard >= num) {
                cnt++;
            } else {
                cntList.add(cnt);
                cnt = 1;    // cnt �ʱ�ȭ
                standard = num;
            }
        }
        // 9, 5���� ������ ��� else�� ���� �����Ƿ� �ۿ��� cnt�� �����������
        cntList.add(cnt);
        answer = new int[cntList.size()];
        for(int i=0; i<cntList.size(); i++){
            answer[i] = cntList.get(i);
        }
        
        // answer ���
        System.out.println(Arrays.toString(answer));
	}

}
