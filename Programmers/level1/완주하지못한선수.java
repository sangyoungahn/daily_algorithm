package level1;

import java.util.HashMap;

public class �����������Ѽ��� {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        //������ ������� ���� map�� ����
        for(String person : completion){
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        //participant�� �����ϸ鼭 �ش� key�� ���� �����ϸ� �ο����� �ϳ��� ����
        for(String person : participant){
            map.put(person, map.getOrDefault(person, 0) - 1);
            
            if(map.get(person) < 0)
                answer = person;
        }
		
        System.out.println(answer);
	}

}
