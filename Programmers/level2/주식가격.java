package level2;

import java.util.ArrayList;

public class �ֽİ��� {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		
		int arrSize = prices.length;
        ArrayList<Integer> cntList = new ArrayList<Integer>();
        int cnt = 0;    //�������� ���� Ƚ�� ī��Ʈ
        
        for(int i=0; i<arrSize; i++) {       //�� ���ذ�
            cnt = 0;    //ī��Ʈ �ʱ�ȭ
            for(int j=i; j<arrSize; j++) {   //�� ���
                if(prices[i]>prices[j] || j==arrSize-1) {   //���簪 > ������
                    cntList.add(cnt);
                    // System.out.println(j + "��° cnt�� : " + cnt);
                    break;
                }
                cnt++;
            }
        }
        
        System.out.println(cntList);
	}

}
