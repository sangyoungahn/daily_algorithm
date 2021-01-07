import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 1. Ǯ�̽ð� : 1�ð� �ʰ�
 * 2. Ǯ�̹�� : ���ڿ� �ش��ϴ� ���ڿ��� map�� �ְ�, �ش� ���ڸ� key������ ���ڿ��� �ҷ��� ó���ϴ� ����
                ��͸� ����ؼ� digits�� ũ�⸸ŭ depth�� ��. �� ���� �� depth�� ���������鼭 �ٽ� ���ȣ���� ��
 * 3. ���� �ð����⵵ : ??
 */
public class LetterCombinationsOf_APhoneNumber {

	public static void main(String[] args) {
		String digits = "23";
		List<String> result = new ArrayList<String>();
		
		result = letterCombinations(digits);
		
		System.out.println(result);
	}
	
	public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> lettersMap = new HashMap<Integer, String>();  //���ڿ� �ش��ϴ� ���� �迭�� �ִ� map
        List<String> result = new ArrayList<String>();
        char[] num = new char[digits.length()];
        //digits�� ���� �ϳ��� �ڸ���
        for(int i=0; i<digits.length(); i++){
            num[i] = digits.charAt(i);
        }
        
        //digits ���� ���� ��� �� ���� ���
        if(digits.isEmpty())
            return result;
        
        //��ȣ�� �´� ���ڵ� mapping
        String[] collections = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0; i<digits.length(); i++){   //digits=23 <- 2, 3
            lettersMap.put(i, collections[num[i]-'0']);
        }
        
        combination(lettersMap, result, 0, digits.length(), "");
        return result;
    }
    
    public static void combination(HashMap<Integer, String> lettersMap, List<String> result, int start, int end, String letter){
        //���� ������ depth���� ���� ����Ʈ�� ����� ����
        if(start == end){
            result.add(letter);
            return;
        }
        
        String item = lettersMap.get(start);
        for(int i=0; i<item.length(); i++){
            letter += item.charAt(i);
            combination(lettersMap, result, start+1, end, letter);  //��� ȣ��
            letter = letter.substring(0,letter.length()-1);     //substring(0,0) -> 0��ġ���� 0������ ���ڿ� �����̹Ƿ� ������ ����!!
        }
    }

}
