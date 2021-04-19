package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 1. Ǯ�̽ð� : 50��
 * 2. ���� �ð����⵵ : O(n)
 * 3. Ǯ�̹��
 * 	(1) 0, 1�� ��� -> ������ ����
 * 	(2) �� ���� ������ ��� -> %, / ������ �ݺ������� ���
 * 		% ������ ����� 1�̸� ī��Ʈ�� ������Ŵ
 * 		/ ������ ���(��)�� 1�̸� �ݺ������� �����ϴ� �� ���� -> �ݺ��� ���� ������ ����� ī��Ʈ Ƚ���� ����(checkCnt�� 0, 1�� �ƴ� ���̽��� ����)
 */
public class leetcode338_Counting_Bits {

	public static void main(String[] args) {
		int num = 2;
		int su = num;
		System.out.println(Arrays.toString(countBits(su)));
	}
	
	public static int[] countBits(int num) {
        int su = num;
        int[] answer = new int[su+1];
        List<Integer> list = new ArrayList<Integer>();
        
        // 0 ~ num���� �ݺ�
        int checkCnt = 0;
        for(int i=0; i<=su; i++){
        	int number = i;
            int nam = 0, mok = 0;
            int cnt = 0;
            // ���� 1�϶����� �ݺ�
            while(mok != 1){
                // 0, 1�϶��� ���̽��� ����
                if(number==0){
                    list.add(0);
                    checkCnt++;
                    break;
                }
                if(number==1){
                    list.add(1);
                    checkCnt++;
                    break;
                }
                nam = number % 2;
                mok = number / 2;
                checkCnt++;
                
                if(nam==1)  cnt++;
                
                // ���� ������ num�� ��
                number = mok;
            }
            // ���� 1�� �Ǹ� cnt�� �����ϰ� list�� �ֱ�
            // 0�� ���� 1�� ��쿡 �ɸ��� �ʰ� �ϱ� ����, number�� mok�� ���Ƿ� ������ 1�� �Ǽ� number�� 0, 1�� �ƴ� �������� �ϸ� �ȵ�
            if(checkCnt >= 3) {
            	cnt++;
                list.add(cnt);
            }
        }
        
        for(int i=0; i<list.size(); i++){
        	try {
        		answer[i] = list.get(i);
			} catch (Exception e) {
				System.out.println(e);
			}
            
        }
        
        return answer;
    }
}
