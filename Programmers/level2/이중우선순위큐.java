package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ���߿켱����ť {

	public static void main(String[] args) {
		String[] operations = {"I 7","I 5","I -5","D -1"};
		
		int[] answer = {};
        String MAXMINUS = "D 1";
        String MINMINUS = "D -1";
        String PREFIX_NUMBER = "I ";
        
        //���� ���� list ����
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<operations.length; i++){
            if(operations[i].contains(PREFIX_NUMBER)){
                //"I 7"���� "I "�� �����ϰ� 7�� ����
                String str = operations[i].replace(PREFIX_NUMBER,"");
                //String���� ���ڸ� int������ ��ȯ
                int num = Integer.parseInt(str);
                list.add(num);
                //���ڸ� list�� ���������� �������� ���� ����
                Collections.sort(list);
            } else if(!list.isEmpty() && operations[i].contains(MAXMINUS)){
                list.remove(list.size()-1); //����Ʈ�� ���� ������ ���� ����
            } else if(!list.isEmpty() && operations[i].contains(MINMINUS)){
                list.remove(0); //����Ʈ�� ù��° ���� ����
            }
        }
        
        if(list.isEmpty()){
            answer = new int[] {0, 0};
        } else {
            answer = new int[] {list.get(list.size()-1), list.get(0)};
        }
        
        //�迭 ���
        for(int i=0; i<answer.length; i++) {
        	System.out.print(answer[i] + " ");
        }
	}

}
