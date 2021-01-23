package level2;
/*
 * 1. Ǯ�̽ð� : 40��
 * 2. Ǯ�̹��
 *      brown + yellow = ��ü ����� ����
        ����� ����� ������ ��� width�� height�� ��� 3�̻��� �Ǿ�� ��
        ���� �ε����� 3 �̻���� "brown + yellow"���� �ݺ��ϸ� height�� ���̸� ã��
        ���� width, height�� ������ "(width - 2) x (height - 2)"�� �Ͽ� yellow�� ũ��� ��ġ�ϴ��� Ȯ��
 * 3. ���� �ð����⵵ : O(N)
 */
import java.util.Arrays;

public class ī�� {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		
		int[] result = solution(brown, yellow);
		
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = {};
        int area = brown + yellow;
        
        //������ ����, ���� ���̸� ��� ���ؼ� ���ǿ� �����ϴ��� Ȯ��
        for(int i=3; i<=area; i++){
            //�� ���� ���� �������� ���̸� ���Ҷ� ������ �������� ��츸 ���
            if(area % i == 0){
                int brwonWidth = i;              //����
                int brwonHeight = area/brwonWidth;     //����
                
                int yellowWidth = brwonWidth - 2;
                int yellowHeight = brwonHeight - 2;
                
                //"(width - 2) x (height - 2)" ���� �� ���� yellow�� ũ��� ������ ����
                if(yellowWidth*yellowHeight == yellow && brwonWidth>=brwonHeight){
                    return new int[]{brwonWidth, brwonHeight};
                }
            }
        }
        
        return answer;
    }
}
