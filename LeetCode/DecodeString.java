import java.util.Stack;

/*
 * 1. Ǯ�̽ð� : 1�ð� �ʰ�
 * 2. Ǯ�̹�� : �ݺ�Ƚ���� �ִ� ����, �ݺ� ���ڿ��� �ִ� ������ ���� �ΰ� ǰ
                ����, "[", "]", ������ ��츦 �� ������ ó��
                ���ڰ� ������ �ݺ�Ƚ���� ���
                "["�� ������ �ݺ�Ƚ���� ���߿� ����ϱ� ���� ���ÿ� �ְ�, �ݺ��ؾ��� ���ڿ��� ����
                "]"�� ������ �ݺ�Ƚ���� �����ͼ� ���ȣ �ȿ� �ִ� ���ڿ��� �ݺ�. �׸��� �� �ݺ��� ���� �տ� ���ÿ��� ������ ���ڿ��� ���̰� �ٽ� Ƚ����ŭ �ݺ�
 * 3. ���� �ð����⵵ : O(n)
 */
public class DecodeString {
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		String result = decodeString(s);
		
		System.out.println(result);
	}

	public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();  //�ݺ�Ƚ���� �����ϴ� ����
        Stack<String> stringStack = new Stack<>();  //���ڸ� �����ϴ� ����
        
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        // ���ڿ��� ũ�⸸ŭ �ݺ�
        for(char c : s.toCharArray()){
            //������ ���
            if('0'<=c && c<='9'){
                count = count * 10 + Integer.parseInt(c+"");
            }
            //"["�� ���
            else if(c=='['){
                countStack.push(count);     //�ݺ�Ƚ���� countStack ���ÿ� ����
                stringStack.push(result.toString());    //�ݺ��ؾ��� ���ڸ� stringStack ���ÿ� ����
                count = 0;      //�ݺ� Ƚ���� �ʱ�ȭ
                result = new StringBuilder();    //�ݺ� ���ڸ� �ʱ�ȭ
            }
            //"]"�� ���
            else if(c==']'){
                StringBuilder temp = new StringBuilder();
                int curCount = countStack.pop();    //�ݺ� Ƚ���� �̾ƿ�
                for(int i=0; i<curCount; i++){
                    temp.append(result);
                }
                result = new StringBuilder(stringStack.pop() + temp);   //stringStack���� ������ ���ڿ�+���� �ݺ��� ���ڿ�
            }
            //������ ���
            else{
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
