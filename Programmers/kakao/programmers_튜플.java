package kakao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * 1. Ǯ�̽ð� : 
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * {{4,2,3},{3},{2,3,4,1},{2,3}} -> [3,2,4,1]
 * {3} : �ϳ��� ���� �ִ� ���� ������ "ù��° Ʃ��"(= 3)
 * {2,3} : �� ���� ���� �ִ� �Ϳ��� ù��° Ʃ���� �����ϸ� "�ι�° Ʃ��"(= 2)
 * {4,2,3} : �� ���� ���� �ִ� �Ϳ��� ù��°, �ι�° Ʃ���� �����ϸ� "����° Ʃ��"(= 4)
 * {2,3,4,1} : �� ���� ���� �ִ� �Ϳ��� ù��°, �ι�°, ����° Ʃ���� �����ϸ� "�׹��� Ʃ��"(=1)
 * -> ���Ұ� 2���� ������ ��쿡 ������ ������ �ڹٲ���� �־, ���Ұ� 1���� ������ ���� ������ 2��° Ʃ���� �������� ���� ����
 * -> n��° Ʃ���� n-1���� ���տ��� ���� ����
 * 
 * ���ڿ� ó��
 * {{4,2,3},{3},{2,3,4,1},{2,3}} -> {4,2,3},{3},{2,3,4,1},{2,3} -> {4,2,3#3#2,3,4,1#2,3} -> 4,2,3#3#2,3,4,1#2,3
 * 
 * arr[0] = 4,2,3
 * arr[1] = 3
 * arr[2] = 2,3,4,1
 * arr[3] = 2,3
 * 
 * -> TreeMap ��� (�ڵ����� Key ���� �������� ���� -> ������ ������ �������� ���� �տ� ��)
 *    key : ������ ����, value : �ش� ������ �迭
 * arr[0] = 3
 * arr[1] = 2,3
 * arr[2] = 4,2,3
 * arr[3] = 2,3,4,1
 * 
 * -> arr�迭 ������ �ִ� ���ڵ��� �߶� TreeMap�� ������ �Բ� �־���
 * TreeMap -> {1=[3], 2=[2,3], 3=[4,2,3], 4=[2,3,4,1]}
 * 
 * -> LinkedHashSet ��� (���Ե� ������� ����, ������ �ߺ� ��� X)
 */
public class programmers_Ʃ�� {
	
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		s = s.substring(1, s.length()-1);
		s = s.replaceAll("\\}\\,\\{", "#");
		s = s.substring(1, s.length()-1);
		
		String[] arr = s.split("#");
		
		Map<Integer, Object> map = new TreeMap<Integer, Object>();
		for(int i=0; i<arr.length; i++) {
			String[] tuple = arr[i].split(",");
			map.put(tuple.length, tuple);
		}
		
		Iterator<Integer> mapItr = map.keySet().iterator();
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		while(mapItr.hasNext()) {
			int key = mapItr.next();
			String[] tupleTemp = (String[]) map.get(key);
			
			// ���� ���� �ߺ��Ǹ� ���� ����
			// ���� �� : 2, 3 / ���� �� : 4, 2, 3 -> 2, 3(���� ��) + 4(���� ��)
			// ���� ������ 4 �ڿ� ���� 2, 3�� ���� ���� �ߺ��ǹǷ� ���� ����
			for(String tuple : tupleTemp) {
				set.add(Integer.valueOf(tuple));
			}
		}
		
		//answer�� �� �ֱ�
		int[] answer = new int[set.size()];
		Iterator<Integer> setItr = set.iterator();
		int i = 0;
		while(setItr.hasNext()) {
			answer[i] = setItr.next();
			i++;
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
