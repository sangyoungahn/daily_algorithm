package level1;

public class 가운데글자가져오기 {
	public static void main(String[] args) {
		String word = "qwer";
		String answer = "";
		char[] wordArr = word.toCharArray();
		char[] tempArr = new char[2];
		
		int length = word.length();
        int mid;
        
        if( (length%2)==0 ) {
            mid = (length/2) - 1;
            tempArr[0] = wordArr[mid];
            tempArr[1] = wordArr[mid+1];
            answer = String.valueOf(tempArr);
        }
        else {
            mid = (length/2);
            answer = String.valueOf(wordArr[mid]);
        }
        
        System.out.println(answer);
	}
}
