import java.util.Arrays;

/*
 * 1. 풀이시간 : 20분
 * 2. 풀이방법
 *      이중 for문을 사용해서 바깥쪽 for문에서는 기준값, 안쪽 for문에서는 비교값을 잡아 비교함
        "기준값<비교값" 이 되면 카운트를 증가시키고 배열에 넣어줌
        단순하게 이중 for문을 사용
 * 3. 예상 시간복잡도 : O(n^2)
 */
public class DailyTemperatures {
	public static void main(String[] args) {
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] resultArray = dailyTemperatures(T);
		
		System.out.println(Arrays.toString(resultArray));
	}
	
	public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int cnt;
        
        //시작 index 지정
        for(int i=0; i<T.length; i++){
            cnt=0;
            //비교 index 지정
            for(int j=i+1; j<T.length; j++){
                if(T[i]<T[j]){
                    cnt++;
                    result[i] = cnt;
                    break;
                }
                cnt++;
            }
        }
        
        return result;
    }
}
