package level2;

import java.util.HashMap;

public class programmers_��ȭ��ȣ��� {

	public static void main(String[] args) {
		String[] phone_book = {"12","123","1235","567","88"};
		
		boolean answer = true;
        HashMap<String, String> hm = new HashMap<String, String>();
        
        // phone_book �� �ϳ��ϳ��� HashMap�� ����
        for(String input : phone_book){
            hm.put(input, input);
        }
        
        // input �����͸� �����ؼ� input�� prefix�� �ٸ� string���� ã�� ��
        for(String target : phone_book){
            for(int i=0; i<target.length(); i++){
                // input �����͸� �ϳ��� �ڸ� ���ڿ��� HashMap�� Key�� �����Ѵٸ� false
                if(hm.containsKey(target.substring(0,i))){
                    answer = false;
                    break;
                }
            }
        }
        
        System.out.println(answer);
	}

}
