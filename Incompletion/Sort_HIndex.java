package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Sort_HIndex {

	public static void main(String[] args) {
//		int[] citations = { 3, 0, 6, 1, 5 };
		int[] citations = { 5, 5, 5, 5 };
		int answer = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> answerList = new ArrayList<>();

		// ArrayList에 값 넣기
		for (int i = 0; i < citations.length; i++) {
			arrayList.add(citations[i]);
		}
		Collections.sort(arrayList);

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println();
		
		for(int i=0; i<arrayList.size(); i++){   //기준값 잡기
            int h = arrayList.get(i);
            int cnt = 0;
            for(int j=0; j<arrayList.size(); j++){   //비교값 잡기
                if(h <= arrayList.get(j)){   //h편 이상인 논문 찾기
                    cnt++;
                }
            }
            //h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었다면
            if(h <= cnt && h >= (arrayList.size() - cnt)){
                answerList.add(h);
            }
            
        }
		for (int i = 0; i < answerList.size(); i++) {
			System.out.print(answerList.get(i) + " ");
		}
		System.out.println();
		
		//정답 배열 내림차순 정리
        Collections.sort(answerList);
        Collections.reverse(answerList);
        
        answer = answerList.get(0);
        System.out.println(answer);
	}

}
