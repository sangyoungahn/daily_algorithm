package easy;

import java.util.ArrayList;
import java.util.List;
/*
 * 1. Ǯ�̽ð� : 14��
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * 	(1) nums �迭�� ���� check �迭�� �ε����� �Ͽ�, �����ϸ� true
 * 	(2) check �迭�� Ž���ϸ� false�� �͵��� answer ����Ʈ�� �ֱ�

 */
public class leetcode448_Find_All_Numbers_Disappeared_in_an_Array {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        List<Integer> answer = new ArrayList<Integer>();
        boolean[] check = new boolean[length+1];
        
        for(int i=0; i<length; i++){
            int idx = nums[i];
            check[idx] = true;
        }
        
        for(int i=1; i<length+1; i++){
            if(!check[i]){
                answer.add(i);
            }
        }
        
        return answer;
    }
}
