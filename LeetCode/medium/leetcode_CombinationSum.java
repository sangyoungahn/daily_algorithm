package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * 1. Ǯ�̽ð� : �ð��ʰ�
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * ����(dfs)�� ����� ��Ʈ��ŷ
 * candidate < target �̸� temp ����Ʈ�� ���� �� ���� target�� "target - candidate" �ؼ� ��� ȣ������
 * target = 0 �� �Ǹ� temp�� �ִ� ������ ���� target �̶�� ���̹Ƿ� result ����Ʈ�� �־��ָ鼭 ���� ��
 * 
 * candidate[0] ���� �����ϸ� candidate[1] ���� ������ ���� ���� ���� candidate[0] ���� �� �ʿ䰡 ����
 * 	-> ��Ʈ��ŷ �Լ��� index�� ���� �ѱ�
 */
public class leetcode_CombinationSum {
	static List<List<Integer>> result;

	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 8;
		
		result = new ArrayList<List<Integer>>();
		for(int i=0; i<candidates.length; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(candidates[i]);
			backtraking(candidates, i, 1, target - candidates[i], temp);
		}
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static void backtraking(int[] candidates, int index, int tempSize, int target, List<Integer> temp) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		
		int leng = candidates.length;
		// �������� �� �ʿ䰡 �����Ƿ� ���ڷ� �Ѿ�� index ���ĺ��� ����
		// candidates���� ���� ��(candidate[i]) > ���ؾ��� ���� ��(target) �̸� �����ϰ� candidate �迭���� ���� ���� ������
		for(int i = index; i<leng; i++) {
			if(candidates[i] <= target) {
				temp.add(candidates[i]);
				backtraking(candidates, i, tempSize+1, target-candidates[i], temp);
				temp.remove(tempSize);	//�� ó��(27 line)�� ũ�⸦ 1�� �Ѱ����Ƿ�
			}
		}
	}

}
