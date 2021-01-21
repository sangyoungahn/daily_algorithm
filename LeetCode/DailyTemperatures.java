import java.util.Arrays;

/*
 * 1. Ǯ�̽ð� : 20��
 * 2. Ǯ�̹��
 *      ���� for���� ����ؼ� �ٱ��� for�������� ���ذ�, ���� for�������� �񱳰��� ��� ����
        "���ذ�<�񱳰�" �� �Ǹ� ī��Ʈ�� ������Ű�� �迭�� �־���
        �ܼ��ϰ� ���� for���� ���
 * 3. ���� �ð����⵵ : O(n^2)
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
        
        //���� index ����
        for(int i=0; i<T.length; i++){
            cnt=0;
            //�� index ����
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
