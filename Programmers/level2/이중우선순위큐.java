package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I 7","I 5","I -5","D -1"};
		
		int[] answer = {};
        String MAXMINUS = "D 1";
        String MINMINUS = "D -1";
        String PREFIX_NUMBER = "I ";
        
        //값을 넣을 list 생성
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<operations.length; i++){
            if(operations[i].contains(PREFIX_NUMBER)){
                //"I 7"에서 "I "를 제거하고 7만 남김
                String str = operations[i].replace(PREFIX_NUMBER,"");
                //String형의 숫자를 int형으로 변환
                int num = Integer.parseInt(str);
                list.add(num);
                //숫자를 list에 넣을때마다 오름차순 정렬 실행
                Collections.sort(list);
            } else if(!list.isEmpty() && operations[i].contains(MAXMINUS)){
                list.remove(list.size()-1); //리스트의 가장 마지막 값을 삭제
            } else if(!list.isEmpty() && operations[i].contains(MINMINUS)){
                list.remove(0); //리스트의 첫번째 값을 삭제
            }
        }
        
        if(list.isEmpty()){
            answer = new int[] {0, 0};
        } else {
            answer = new int[] {list.get(list.size()-1), list.get(0)};
        }
        
        //배열 출력
        for(int i=0; i<answer.length; i++) {
        	System.out.print(answer[i] + " ");
        }
	}

}
