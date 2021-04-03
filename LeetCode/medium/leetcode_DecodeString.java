package medium;

import java.util.Stack;

/*
 * 1. Ǯ�̽ð� : 
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * 	(case 1) ����
 * 		�ݺ�Ƚ���� ������ ���(���ڸ�, ���ڸ� ������ ���)
 * 	(case 2) "["
 * 		1. �ݺ�Ƚ���� countStack�� push
 * 		2. �տ��� �ݺ��ؼ� ������� ���ڸ� stringStack�� push
 * 		3. �ݺ�Ƚ��(count)�� �ݺ����� ������� ���ڿ�(result)�� �ʱ�ȭ -> ���ο� �͵��� �޾ƾ��ϹǷ�
 *  (case 3) "]"
 *  	1. �ݺ�Ƚ���� countStack���� ����
 *  	2. �ݺ�Ƚ����ŭ ���ڿ��� �ݺ��� ���ڿ��� ����(temp)
 *  	3. ���ݱ��� ������� �ݺ� ���ڿ�(result) + ���� �ܰ迡�� ������� �ݺ� ���ڿ�(temp) -> ���⼭ ���� result�� "["�� ������ stackStack�� push
 */	
public class leetcode_DecodeString {

	public static void main(String[] args) {
//		String s = "3[a]2[bc]";
//		String s = "3[a2[c]]";
		String s = "2[abc]3[cd]ef";
		
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> stringStack = new Stack<String>();
		
		StringBuilder result = new StringBuilder();
		int count = 0;
		
		// ���ڿ� ���̸�ŭ �ݺ�
		for(char c : s.toCharArray()) {
			// 1. ������ ���
			if('0'<=c && c<='9') {
				count = 10 * count + Integer.parseInt(c+"");
			}
			// 2. "["�� ���
			else if(c=='[') {
				countStack.push(count);
				stringStack.push(result.toString());	// �̰� �� 53���� ������ ���� �ȵǴ��� ������غ���
				count = 0;
				result = new StringBuilder();
			}
			//  3. "]"�� ���
			else if(c==']') {
				StringBuilder temp = new StringBuilder();
				int curCount = countStack.pop();
				for(int i=0; i<curCount; i++) {
					temp.append(result);
				}
				result = new StringBuilder(stringStack.pop() + temp);
			}
			// 4. ������ ���
			else {
				result.append(c);
			}
		}
		System.out.println(result);
	}

}
