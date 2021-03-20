package easy;

import java.util.HashMap;
/*
 * 1. Ǯ�̽ð� : 
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * - nums �迭�� ���鼭 ���� ���ڸ� key�� map�� ���� -> key : ���� ����, value : �ش� ���ڰ� ���� Ƚ��
 * - key�� �����̹Ƿ� �ش� ���ڸ� key�� ���ڰ� ���� Ƚ���� �̾ƿ�
 * - �� Ƚ���� ���ϸ� ���� ū ���� ���� �� �ְ�, ���� ū ���� index ���� ���� �� ���� -> index ���� 
 */
public class letcode169_MajorityElement_Sol {
	
	public static void main(String[] args) {
		int[] nums = {3,3,4};
//		int[] nums = {2,2,1,1,1,2,2};
		int halfCnt = nums.length/2;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// ��ü ���鼭 map�� �־���
		for(int i : nums) {
			// map�� �ش� ���ڰ� ������ -> �����ͼ� 1�� ���ϰ� ����
			// map�� �ش� ���ڰ� ������ -> ����Ʈ������ ������ 0�� ����
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int maxNum = Integer.MIN_VALUE;
		int resultIdx = 0;
		
		for(int i : nums) {
			if(map.get(i) > maxNum) {
				if(map.get(i) >= halfCnt)
				{
					maxNum = map.get(i);
					resultIdx = i;
				}
			}
		}
		
		System.out.println(resultIdx);
	}
}
