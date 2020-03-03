package FullSearch;

public class mockTest {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		int size = answers.length;
        int[] cnt = new int[3];
        int max = -1;
        
        int[] oneAns = {1,2,3,4,5}; //5
        int[] twoAns = {2,1,2,3,2,4,2,5};   //8
        int[] threeAns = {3,3,1,1,2,2,4,4,5,5}; //10
        
        for(int idx=0; idx<size; idx++){
            
        }
        
        //1번 수포자
        for(int i=0; i< (size/5); i++){
            for(int idx=0; idx<size; idx++){
                if(answers[idx] == oneAns[idx])  cnt[0]++;
            }
        }
        //2번 수포자
        for(int i=0; i< (size/8); i++){
            for(int idx=0; idx<size; idx++){
                if(answers[idx] == twoAns[idx])  cnt[1]++;
            }
        }
        //3번 수포자
        for(int i=0; i< (size/10); i++){
            for(int idx=0; idx<size; idx++){
                if(answers[idx] == threeAns[idx])  cnt[2]++;
            }
        }
        System.out.println("cnt[0] : " + cnt[0]);
        System.out.println("cnt[1] : " + cnt[1]);
        System.out.println("cnt[2] : " + cnt[2]);
        System.out.println("=====================");
        
        //오름차순 정렬
        // Arrays.sort(cnt);
        //가장 큰 값을 저장
        // max = cnt[2
        int maxCnt = 0;
        for(int i=0; i<3; i++){
            if(cnt[i]>=max) {
                max = cnt[i];
                maxCnt++;
                System.out.println("maxCnt : " + maxCnt);
            }
        }
        System.out.println("max : " + max);
        for(int i=0; i<3; i++){
            System.out.println("cnt["+i+"] : " + cnt[i]);
        }
        System.out.println("=====================");
        
        int idxCnt = 0;
        int[] result = new int[maxCnt];
        for(int i=0; i<3; i++){
            if(cnt[i] == max){
                System.out.println("max값과 같을 경우 : " + max);
                System.out.println("cnt["+i+"] : " + cnt[i]);
                result[idxCnt] = i+1;
                System.out.println("result["+i+"] : " + result[i]);
                idxCnt++;
                
                if(idxCnt == maxCnt)
                    break;
            }
            
        }
        
        System.out.println(result);
	}

}
