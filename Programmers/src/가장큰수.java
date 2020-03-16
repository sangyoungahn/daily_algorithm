package sort;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수_Sol {

	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };
		String answer = "";
		
		//int형 배열을 String 배열로 변환
        String[] strNum = new String[numbers.length];
        for(int i=0; i<strNum.length; i++){
            strNum[i] = String.valueOf(numbers[i]);
        }
        
        //String 배열을 내림차순으로 정렬
        Arrays.sort(strNum, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        //0이 여러분 중복될 경우를 대비해 처리해줌
        if(strNum[0].startsWith("0")){
            answer += "0";
        }else{
            for(int j=0; j<strNum.length; j++){
                answer += strNum[j];
            }
        }
        
        System.out.println(answer);
	}

}
