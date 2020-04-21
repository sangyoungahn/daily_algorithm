package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Sort_HIndex {

	public static void main(String[] args) {
//		int[] citations = { 3, 0, 6, 1, 5 };
		int[] citations = { 5, 5, 5, 5 };
		
		int n = citations.length;
		int answer = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> answerList = new ArrayList<>();

		// ArrayList에 값 넣기
		for (int i = 0; i < n; i++) {
			arrayList.add(citations[i]);
		}
		Collections.sort(arrayList);

		//output test
		for (int i = 0; i < n; i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println();
		System.out.println("===========");
		
		int max = arrayList.get(arrayList.size()-1);
		System.out.println("max : " + max);
		for(int i=0; i<=max; i++){   //기준값 잡기
            int h = i;
            System.out.println("h : " + h);
            int cnt = 0;
            for(int j=0; j<n; j++){   //비교값 잡기
                if(h <= arrayList.get(j)){   //h편 이상인 논문 찾기
                    cnt++;
                }
            }
            System.out.println("cnt : " + cnt);
            System.out.println("n - cnt : " + (n - cnt));
            System.out.println("===========");
            //h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었다면
            if(h <= cnt && h >= (n - cnt)){
            	System.out.println(h+"는 answerList에 들어감");
            	System.out.println("===========");
                answerList.add(h);
            }
            
        }
		
		//output test
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
