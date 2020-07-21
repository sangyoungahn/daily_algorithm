package level1;

import java.util.HashMap;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        //완주한 사람들을 전부 map에 넣음
        for(String person : completion){
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        //participant를 순휘하면서 해당 key의 값이 존재하면 인원수를 하나씩 빼줌
        for(String person : participant){
            map.put(person, map.getOrDefault(person, 0) - 1);
            
            if(map.get(person) < 0)
                answer = person;
        }
		
        System.out.println(answer);
	}

}
