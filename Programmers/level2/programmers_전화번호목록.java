package level2;

import java.util.HashMap;

public class programmers_전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book = {"12","123","1235","567","88"};
		
		boolean answer = true;
        HashMap<String, String> hm = new HashMap<String, String>();
        
        // phone_book 값 하나하나를 HashMap에 저장
        for(String input : phone_book){
            hm.put(input, input);
        }
        
        // input 데이터를 분해해서 input의 prefix를 다른 string에서 찾는 것
        for(String target : phone_book){
            for(int i=0; i<target.length(); i++){
                // input 데이터를 하나씩 자른 문자열이 HashMap의 Key에 존재한다면 false
                if(hm.containsKey(target.substring(0,i))){
                    answer = false;
                    break;
                }
            }
        }
        
        System.out.println(answer);
	}

}
