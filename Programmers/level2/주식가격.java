package level2;

import java.util.ArrayList;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		
		int arrSize = prices.length;
        ArrayList<Integer> cntList = new ArrayList<Integer>();
        int cnt = 0;    //내려가지 않은 횟수 카운트
        
        for(int i=0; i<arrSize; i++) {       //비교 기준값
            cnt = 0;    //카운트 초기화
            for(int j=i; j<arrSize; j++) {   //비교 대상값
                if(prices[i]>prices[j] || j==arrSize-1) {   //현재값 > 다음값
                    cntList.add(cnt);
                    // System.out.println(j + "번째 cnt값 : " + cnt);
                    break;
                }
                cnt++;
            }
        }
        
        System.out.println(cntList);
	}

}
